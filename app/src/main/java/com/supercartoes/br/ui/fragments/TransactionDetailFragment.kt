package com.supercartoes.br.ui.fragments

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.supercartoes.br.R
import com.supercartoes.br.SuperDigitalApplication
import com.supercartoes.br.ui.activities.HomeActivity
import com.supercartoes.br.ui.utils.*
import com.supercartoes.br.utils.CustomDimension
import com.supercartoes.br.utils.Mask
import com.supercartoes.br.utils.OperationTypes
import kotlinx.android.synthetic.main.fragment_transaction_detail.view.*
import kotlinx.android.synthetic.main.item100.view.*
import kotlinx.android.synthetic.main.item50.view.*
import superdigital.com.superdigitalotp.callbacks.SuperdigitalCallback
import superdigital.com.superdigitalotp.main.SuperDigital
import superdigital.com.superdigitalotp.operations.OperationReceipt
import superdigital.com.superdigitalotp.operations.responses.ResponseReceipt
import superdigital.com.superdigitalotp.repository.models.Error
import java.text.SimpleDateFormat


private const val HISTORIC = "historic"
private const val TYPE = "type"
private const val SOURCE = "source"
private const val NULL_DISCOUNT_VALUE = "0,00"

class TransactionDetailFragment : Fragment() {

    lateinit var mView: View
    lateinit var loader: View
    lateinit var tvLoaderMsg: TextView
    lateinit var tvValue: TextView
    lateinit var content: ScrollView
    lateinit var errorView: LinearLayout


    lateinit var toolbar: CardView

    lateinit var tvTitle: TextView
    lateinit var ivBackArrow: ImageView
    lateinit var ivClose: ImageView

    lateinit var ivCategory: ImageView
    lateinit var tvCategory: TextView


    val pagamento = "ComprovantePagamento"
    val transferenciaDocTed = "ComprovanteTransferenciaDocTed"
    val transferencia = "ComprovanteTransferencia"
    val cargaRecorrente = "ComprovantesCargasRecorrentes"
    val recargaCelular = "ComprovanteRecargaCelular"
    val cargaPrePago = "ComprovanteCargaPrePago"
    val cargaDocTed = "ComprovanteCargaDocTed"
    val cargaBilheteTransporte = "ComprovanteCargaBilheteTransporte"
    val cambioMoeda = "ComprovanteCambioMoeda"
    val autorizacao = "ComprovanteAutorizacao"
    val vaquinhaRachar = "ComprovanteVaquinhaRachar"
    val generico = "ComprovanteGenerico"

    lateinit var btShare: AppCompatButton

    private var App = SuperDigitalApplication.initializer
    private var screentag = "Detalhes da Transação"
    private var customDimension: Array<CustomDimension> = emptyArray()

    var id: Long = 0
    var type: Long = 0
    var source: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            this.id = it.getLong(HISTORIC)
            this.type = it.getLong(TYPE)
            this.source = it.getString(SOURCE, "")
        }

        customDimension = arrayOf(
            CustomDimension(Const.CURRENT_PLAN, ""),
            CustomDimension("tipoTransacao", getString(OperationTypes().getType(type).title))
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //  App.firebaseScreenTransition(screentag, "", customDimension)
        mView = inflater.inflate(R.layout.fragment_transaction_detail, container, false)

        initWidgets(mView)

        btShare.setOnClickListener {
            activity!!.shareScreenShot(view!!.findViewById(R.id.printView))
        }

        showLoader(getString(R.string.fetching_receipt))

        SuperDigital.Builder((this@TransactionDetailFragment.activity!! as HomeActivity))
            .operation(OperationReceipt(id))
            .enqueue(object : SuperdigitalCallback<ResponseReceipt> {
                override fun onSuccess(response: ResponseReceipt) {
                    populateView(response)
                    loader.visibility = View.GONE
                }

                override fun onFailure(error: Error) {
                    try {
                        if (view != null && activity != null) {
                            //  App.validateError((this@TransactionDetailFragment.activity!! as MainActivity), error)
                            loader.visibility = View.GONE
                            content.visibility = View.GONE
                            errorView.visibility = View.VISIBLE
                            (activity!! as HomeActivity).noReceipt()
                        }
                    } catch (e: java.lang.Exception) {
                        // e.logCrashLytics()
                    }

                }
            })
        return mView
    }

    fun initWidgets(view: View) {
        view.customizeToolbar(title = R.string.transaction_title, back = null, close = {
            //  App.firebaseLog(screentag, screentag, Const.Rotulo.toqueBtnClose.tag, false, "")
            activity!!.supportFragmentManager.popBackStackImmediate()
        })

        ivCategory = view.findViewById(R.id.ivCategory)
        tvCategory = view.findViewById(R.id.tvCategory)
        content = view.findViewById(R.id.content)
        loader = view.findViewById(R.id.loader)
        tvValue = view.findViewById(R.id.tvValue)
        tvLoaderMsg = view.findViewById(R.id.tvLoaderMsg)
        errorView = view.findViewById(R.id.errorView)

        btShare = view.findViewById(R.id.btShare)
        btShare.addButtonAnimation()

    }

    private fun addField100(label: String, value: String?) {
        val subsadapter = LayoutInflater.from(context).inflate(R.layout.item100, null)
        subsadapter.label100.text = label
        subsadapter.value100.text = value
        mView.viewItems.addView(subsadapter, mView.viewItems.childCount)
    }

    private fun addField50(labela: String, valuea: String?, labelb: String, valueb: String?) {
        val subsadapter = LayoutInflater.from(context).inflate(R.layout.item50, null)
        subsadapter.label50a?.text = labela
        subsadapter.value50a?.text = valuea
        subsadapter.label50b?.text = labelb
        subsadapter.value50b?.text = valueb
        mView.viewItems.addView(subsadapter, mView.viewItems.childCount)
    }

    fun populateView(comp: ResponseReceipt) {

        if (context == null)
            return

        val receipt = comp.receipt

        if (context != null) ivCategory.setImageDrawable(
            ContextCompat.getDrawable(
                context!!,
                OperationTypes().getType(type).img
            )
        )
        tvCategory.text = getString(OperationTypes().getType(type).title)

//        if(comp.receiptType == cambioMoeda){
//
//            if (receipt!!.currencySymbol != null) {
//                tvValue.text = Mask.maskCurrency(receipt.currencyOrigenAcronym!!, receipt.value!!)
//            } else {
//                tvValue.text = "%.2f".format(receipt.value)
//            }
//
//        }else {
        if (receipt!!.currencySymbol != null) {
            tvValue.text = Mask.maskCurrency(receipt.currencySymbol!!, receipt.value!!)
        } else {
            tvValue.text = "%.2f".format(receipt.value)
        }
//        }
        when (comp.receiptType) {

            pagamento -> {
                addField100(getString(R.string.identification), receipt.category ?: "")
                addField100(getString(R.string.barcode), receipt.barcode ?: "")
                addField100(
                    getString(R.string.discount), receipt.currencySymbol ?: ""
                    + receipt.discount ?: NULL_DISCOUNT_VALUE
                )
                addField100(
                    getString(R.string.transaction_date),
                    SDUtil.getDateObject(receipt.dateCreation.toString())!!.toFullDateTime()
                )
                addField100(getString(R.string.authentication), receipt.authentication ?: "")
            }
            transferenciaDocTed -> {
                addField100(getString(R.string.identification), receipt.category ?: "")
                addField100(getString(R.string.bank), receipt.bank ?: "")
                addField50(
                    getString(R.string.agency), (receipt.agency
                        ?: "").toString(), getString(R.string.account), receipt.account
                        ?: ""
                )
                addField100(getString(R.string.account_type), receipt.accountType ?: "")

                addField50(
                    getString(R.string.transferred_to), receipt.destinataryName
                        ?: receipt.destinatary ?: ""
                        ?: "", getString(
                        if ((receipt.destinataryDocument ?: "").length > 11) {
                            R.string.cnpj
                        } else {
                            R.string.cpf
                        }
                    ), receipt.destinataryDocument!!.formatDoc()
                )

                val tax = if (receipt.rate != null && receipt.rate!! > 0.0) {
                    receipt.currencySymbol ?: "" + " " + (receipt.rate ?: "").toString()
                } else {
                    getString(R.string.no_tax)
                }

                addField50(
                    getString(R.string.tax), tax, getString(R.string.transfered_by), receipt.carrier
                        ?: ""
                )

                addField100(
                    getString(R.string.transaction_date),
                    SDUtil.getDateObject(receipt.dateCreation.toString())!!.toFullDateTime()
                )
                addField100(getString(R.string.authentication), receipt.authentication ?: "")
            }
            transferencia -> {
                addField100(getString(R.string.identification), receipt.category ?: "")
                if (isCard(source)) {
                    val card = source.substringAfter(" ")
                    addField100(getString(R.string.card), card)
                }
                addField100(getString(R.string.transferred_to), receipt.destinataryName ?: receipt.destinatary ?: "")
                addField100(getString(R.string.transfered_by), receipt.carrier ?: "")
                addField100(
                    getString(R.string.transaction_date),
                    SDUtil.getDateObject(receipt.dateCreation.toString())!!.toFullDateTime()
                )
                addField100(getString(R.string.authentication), receipt.authentication ?: "")
            }
            recargaCelular -> {
                addField100(getString(R.string.identification), receipt.category ?: "")
                addField100(getString(R.string.phone), receipt.phone ?: "")
                addField100(getString(R.string.operator), receipt.operator ?: "")
                addField100(getString(R.string.made_by), receipt.carrier ?: "")
                addField100(
                    getString(R.string.transaction_date),
                    SDUtil.getDateObject(receipt.dateCreation.toString())!!.toFullDateTime()
                )
                addField100(getString(R.string.authentication), receipt.authentication ?: "")
            }
            cargaPrePago -> {
                addField100(getString(R.string.identification), receipt.category ?: "")
                addField100(getString(R.string.bank), receipt.bank ?: "")
                addField100(
                    getString(R.string.tax), receipt.currencyAcronym
                        ?: getString(R.string.no_tax)
                        + if (receipt.rate != null && receipt.rate!! > 0) "%.2f".format(receipt.rate.toString()) else ""
                )
                addField100(
                    getString(R.string.transaction_date),
                    SDUtil.getDateObject(receipt.dateCreation.toString())!!.toFullDateTime()
                )
                addField100(getString(R.string.authentication), receipt.authentication ?: "")

            }
            cambioMoeda -> {
                addField100(getString(R.string.identification), receipt.category ?: "")
                addField50(
                    getString(R.string.coin_origin), (receipt.currencyOrigenAcronym
                        ?: "") + " " + if (receipt.valueTotalCurrencyOrigen != null) "%.2f".format(receipt.valueTotalCurrencyOrigen) else ""
                    , getString(R.string.coin_destiny), (receipt.currencyAcronymDestiny
                        ?: "") + " " + if (receipt.currencyDestinyValue != null) "%.2f".format(receipt.currencyDestinyValue) else ""
                )
                addField50(
                    getString(R.string.dolar_value),
                    getString(R.string.usd) + " " + if (receipt.velueInDollar != null) "%.2f".format(receipt.velueInDollar) else "",
                    getString(R.string.price),
                    (receipt.currencyAcronym
                        ?: "") + " " + if (receipt.rateDollar != null) "%.2f".format(receipt.rateDollar) else ""
                )
                addField100(
                    getString(R.string.exchange_rate), (receipt.currencyAcronym ?: "") + " "
                            + if (receipt.rateExchange != null) "%.2f".format(receipt.rateExchange) else ""
                )
                addField100(
                    "IOF", (receipt.currencyAcronym
                        ?: "") + " " + (if (receipt.iof != null) "%.2f".format(receipt.iof) else "").toString()
                )
                addField100(
                    getString(R.string.transaction_date),
                    SDUtil.getDateObject(receipt.dateCreation.toString())!!.toFullDateTime()
                )
                addField100(getString(R.string.authentication), receipt.authentication ?: "")
            }
            cargaDocTed -> {
                addField100(getString(R.string.identification), receipt.category ?: "")
                addField100(
                    getString(R.string.tax), receipt.currencyAcronym ?: "" + (receipt.rate
                        ?: "").toString()
                )
                addField100(
                    getString(R.string.transaction_date),
                    SDUtil.getDateObject(receipt.dateCreation.toString())!!.toFullDateTime()
                )
                addField100(getString(R.string.authentication), receipt.authentication ?: "")
            }
            cargaRecorrente, generico -> {
                addField100(
                    getString(R.string.transaction_date),
                    SDUtil.getDateObject(receipt.dateCreation.toString())!!.toFullDateTime()
                )
                addField100(getString(R.string.authentication), receipt.authentication ?: "")
            }
            vaquinhaRachar -> {
                addField100(getString(R.string.identification), if (receipt.category != null) receipt.category else "")
                addField100(getString(R.string.receiver), receipt.recipient.toString())
                addField100(
                    getString(R.string.transaction_date),
                    SDUtil.getDateObject(receipt.dateCreation.toString())!!.toFullDateTime()
                )
                addField100(getString(R.string.authentication), receipt.authentication ?: "")
            }
            autorizacao -> {
                addField100(getString(R.string.identification), receipt.establishmentInfo ?: "")
                addField100(
                    getString(R.string.transaction_date),
                    SDUtil.getDateObject(receipt.dateCreation.toString())!!.toFullDateTime()
                )
                addField100(getString(R.string.card), "**** **** **** " + receipt.cardFinalNumber)
                addField100(getString(R.string.transaction_card_holder), receipt.cardName ?: "")
                addField100(getString(R.string.authentication), receipt.authentication ?: "")
            }
            cargaBilheteTransporte -> {
                addField100(getString(R.string.identification), receipt.category ?: "")
                addField100(getString(R.string.ticket_number), receipt.ticktNumber ?: "")
                addField100(getString(R.string.holder), receipt.carrier ?: "")
                addField100(
                    getString(R.string.transaction_date),
                    SDUtil.getDateObject(receipt.dateCreation.toString())!!.toFullDateTime()
                )
                addField100(getString(R.string.authentication), receipt.authentication ?: "")
            }

            else -> {
                content.visibility = View.GONE
                errorView.visibility = View.VISIBLE
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        if (WRITE == requestCode)
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                btShare.performClick()
            } else {
                val snack = Snackbar.make(btShare, R.string.permission_write, Snackbar.LENGTH_LONG)
                snack.setAction(R.string.active) {
                    val intent = Intent()
                    intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                    val uri = Uri.fromParts("package", activity!!.packageName, null)
                    intent.data = uri
                    startActivity(intent)
                }
                snack.show()
            }
    }

    override fun onResume() {
        super.onResume()
        SDUtil.hideKeyboard(activity!!)
    }

    private fun toDate(date: String): String {
        var result = ""
        try {
            var sdfnewformat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS")
            val newDate = sdfnewformat.parse(date)
            sdfnewformat = SimpleDateFormat("dd/MM/yyyy")
            result = sdfnewformat.format(newDate)
        } catch (e: Exception) {
            //   e.logCrashLytics()
            return result
        }
        return result
    }

    private fun showLoader(msg: String) {
        tvLoaderMsg.text = msg
        loader.visibility = View.VISIBLE
    }

    private fun isCard(source: String): Boolean {
        return source.matches(Regex("[:\\.\\w\\s\\d]*[Xn,]{4,}[:\\.\\w\\s\\d]*"))
    }

    companion object {
        @JvmStatic
        fun newInstance(id: Long, type: Long, source: String) =
            TransactionDetailFragment().apply {
                arguments = Bundle().apply {
                    putLong(HISTORIC, id)
                    putLong(TYPE, type)
                    putString(SOURCE, source)
                }
            }
    }

}
