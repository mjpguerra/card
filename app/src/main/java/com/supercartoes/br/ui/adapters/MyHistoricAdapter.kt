package layout.superdigital.com.superdigitallayout.adapters

import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.supercartoes.br.R
import com.supercartoes.br.ui.utils.SDUtil
import com.supercartoes.br.ui.utils.isEqualsDay
import com.supercartoes.br.ui.utils.toString
import com.supercartoes.br.utils.Mask
import com.supercartoes.br.utils.OperationTypes
import kotlinx.android.synthetic.main.item_date.view.*
import superdigital.com.superdigitalotp.operations.responses.ResponseHistoric
import java.util.*

/**
 * @author Mario Guerra on 10/07/2019
 */

class MyHistoricAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var listFull: MutableList<ResponseHistoric.HistoricItem> = mutableListOf()
    var listFiltred: MutableList<ResponseHistoric.HistoricItem> = mutableListOf()
    var listScreen: MutableList<Any> = mutableListOf()

    private lateinit var ivIn: Drawable
    private lateinit var ivOut: Drawable
    lateinit var parent: ViewGroup


    lateinit var clickListener: ItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 1) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_historic, parent, false) as View
            this.parent = parent

            ivIn = ContextCompat.getDrawable(parent.context, R.drawable.ic_in)!!
            ivOut = ContextCompat.getDrawable(parent.context, R.drawable.ic_out)!!
            HistoricViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_date, parent, false) as View
            DateViewHolder(view)
        }
    }

    override fun getItemCount(): Int {
        return listScreen.size
    }

    override fun getItemViewType(position: Int): Int {

        return if (listScreen.get(position) is ResponseHistoric.HistoricItem) 1 else 2
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is HistoricViewHolder) {
            holder.bind(listScreen[position] as ResponseHistoric.HistoricItem)

        } else {
            holder as DateViewHolder
            holder.bind(listScreen[position] as String)
        }
    }

    inner class DateViewHolder(val view: View) : RecyclerView.ViewHolder(view)  {
        fun bind(date: String) {
            view.tvDate.text = date
        }
    }

    inner class HistoricViewHolder(val view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        var tvValue: TextView = view.findViewById(R.id.tvValue)
        var tvDescription: TextView = view.findViewById(R.id.tvDescription)
        var tvDate: TextView = view.findViewById(R.id.tvDate)
        var tvType: ImageView = view.findViewById(R.id.ivTransaactionType)
        var tvSource: TextView = view.findViewById(R.id.tvSource)
        var ivIcon: ImageView = view.findViewById(R.id.ivIcon)
        var historic: ResponseHistoric.HistoricItem? = null

        init {
            view.setOnClickListener(this)
        }

        fun bind(historic: ResponseHistoric.HistoricItem) {
            this.historic = historic
            val infos = historic.description!!.split("|")
            when {
                infos.count() == 1 -> {
                    tvDescription.text = infos[0]
                    tvSource.text = ""
                }
                infos.count() >= 2 -> {
                    tvDescription.text = infos[0]
                    tvSource.text = infos.last()
                }
                else -> {
                    tvDescription.text = ""
                    tvSource.text = ""
                }
            }
            tvValue.text = Mask.maskCurrency(historic.currency!!, historic.value!!)
            tvDate.text = SDUtil.getDate(historic.date.toString())
//            holder.isRecyclable
            tvType.setImageDrawable(if (historic.value!!.toDouble() > 0) ivIn else ivOut)
            ivIcon.setImageDrawable(
                ContextCompat.getDrawable(
                    parent.context,
                    OperationTypes().getType(historic.type!!.toLong()).img
                )
            )
        }

        override fun onClick(v: View?) {
            var id: Long? = null
            var type: Int? = null

            if (listScreen.isNotEmpty()) {
                id = historic!!.id
                type = historic!!.type
            }
            clickListener.onItemClick(view, id ?: 0, type ?: 0, tvSource.text.toString())
        }
    }

    fun updateListNotifyDataSetChange(list: MutableList<ResponseHistoric.HistoricItem>) {
        this.listFull = list
        this.listFiltred.clear()
        this.listFiltred.addAll(list)
        agroupScreenList()
    }

    var textFilter: String = ""
    private fun filter(text: String = textFilter) {
        textFilter = text
        val textAfter = text.toLowerCase(Locale.getDefault())
        listFiltred.clear()

        if (textAfter.isEmpty()) {
            listFiltred.addAll(listFull)
        } else {
            for (it in listFull) {

                var value  = String.format("%.2f", it.value)
                var dataAux = SDUtil.getDate(it.date.toString())
                var date= SDUtil.parseDate(it.date!!, "yyyy-MM-dd'T'HH:mm:ss")!!
                var dataAux2 = date.toString("dd/MM/yyyy")

                if (it.description!!.toLowerCase(Locale.getDefault()).contains(textAfter) ||
                    dataAux2.toLowerCase(Locale.getDefault()).contains(textAfter) ||
                    value.toLowerCase(Locale.getDefault()).contains(textAfter) ||
                    dataAux.toLowerCase(Locale.getDefault()).contains(textAfter)) {

                    listFiltred.add(it)
                }
            }
        }

    }

    fun agroupScreenList() {

        filter()

        listFiltred.sortByDescending {
            SDUtil.parseDate(it.date!!, "yyyy-MM-dd'T'HH:mm:ss")!!
        }


        var newsItens = mutableListOf<Any>()
        var date: Date? = null
        for (it in listFiltred) {
            var dateTemp = SDUtil.parseDate(it.date!!, "yyyy-MM-dd'T'HH:mm:ss")!!
            if (date == null || !date.isEqualsDay(dateTemp)) {
                newsItens.add(dateTemp.toString("dd/MM/yyyy") as Any)
                date = dateTemp
            }
            newsItens.add(it)
        }
        listScreen = newsItens
        notifyDataSetChanged()
    }


    interface ItemClickListener {
        fun onItemClick(view: View, id: Long, type: Int, source: String)
    }

    fun setMyClickListener(itemClickListener: ItemClickListener?) {
        this.clickListener = itemClickListener!!
    }

}