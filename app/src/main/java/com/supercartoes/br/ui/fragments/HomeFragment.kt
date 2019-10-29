package com.superca

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.text.Html
import android.text.InputFilter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.facebook.shimmer.ShimmerFrameLayout
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.supercartoes.br.R
import com.supercartoes.br.repository.AppPreferencesRegister
import com.supercartoes.br.ui.activities.HomeActivity
import com.supercartoes.br.ui.activities.LoginActivity
import com.supercartoes.br.ui.utils.*
import kotlinx.android.synthetic.main.bottom_sheet_home.view.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.loader_fs.*
import layout.superdigital.com.superdigitallayout.adapters.MyHistoricAdapter
import superdigital.com.superdigitalotp.callbacks.SuperdigitalCallback
import superdigital.com.superdigitalotp.main.SuperDigital
import superdigital.com.superdigitalotp.operations.OperationCards
import superdigital.com.superdigitalotp.operations.OperationHistoric
import superdigital.com.superdigitalotp.operations.requests.RequestCard
import superdigital.com.superdigitalotp.operations.responses.ResponseCards
import superdigital.com.superdigitalotp.operations.responses.ResponseHistoric
import superdigital.com.superdigitalotp.repository.models.Error
import superdigital.com.superdigitalotp.utils.DebugSuperdigital
import superdigital.com.superdigitalotp.utils.HistoryOperationType
import java.util.*

/**
 * @author Mario Guerra on 10/07/2019
 */

class HomeFragment : Fragment(), MyHistoricAdapter.ItemClickListener {

    val TAG = HomeFragment::class.java.simpleName
    private lateinit var noItems: LinearLayout
    private lateinit var rcHistoric: RecyclerView
    private var listener: OnFragmentInteractionListener? = null
    private var balance: String = "0,00"
    lateinit var shimmer: ShimmerFrameLayout
    lateinit var shimmerContent: LinearLayout
    private lateinit var mLayoutManager: LinearLayoutManager
    private lateinit var toolbar: Toolbar
    lateinit var shimmerTv: TextView
    private lateinit var llBallance: TextView
    private lateinit var noResults: LinearLayout
    private lateinit var noResultsQuery: TextView
    lateinit var collapsingToolbarLayout: CollapsingToolbarLayout
    private lateinit var tvHideBallance: TextView
    lateinit var appBarLayout: AppBarLayout
    private lateinit var cvSearch: CardView
    private lateinit var svSearch: SearchView
    private lateinit var etSearchHint: TextView
    private lateinit var home: HomeFragment
    private var shimmerLoader = false
    private var mCurrentState = State.IDLE
    private var cards: MutableList<RequestCard>? = null
    private lateinit var preferencesRegister: AppPreferencesRegister
    private lateinit var adapterHistoric: MyHistoricAdapter
    lateinit var dots1: TextView
    lateinit var dots2: TextView
    lateinit var dots3: TextView
    private lateinit var tvLasteNumber: TextView
    lateinit var tvValidation: TextView
    lateinit var tvNameUser: TextView
    lateinit var tvCardType: TextView
    lateinit var tvValid: TextView
    lateinit var ivFlag: ImageView
    lateinit var bgCard: RelativeLayout
    lateinit var space1: View
    lateinit var rlBlocked: RelativeLayout
    lateinit var loader: LinearLayout
    lateinit var refreshLayout: SwipeRefreshLayout
    lateinit var progress: ProgressBar

    enum class State {
        EXPANDED,
        COLLAPSED,
        IDLE
    }

    interface OnFragmentInteractionListener {
        fun showHistoricEmptyForSearch()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        preferencesRegister = AppPreferencesRegister(context)
        adapterHistoric = MyHistoricAdapter()
    }

    fun setHome(f: HomeFragment) {
        try {
            this.home = f
        } catch (e: java.lang.Exception) {
            //  e.logCrashLytics()
        }
    }

    override fun onResume() {
        super.onResume()
        setCurrencyTitle()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        initWidgets(view)

        toolbar = view.findViewById(R.id.toolbar) as Toolbar

        (activity as AppCompatActivity).setSupportActionBar(toolbar)

        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedText)

        shimmerLoader = true

        startShimmer()

        stopShimmer()

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setCurrencyTitle()
    }

    override fun onStart() {
        super.onStart()
        getCards()
    }

    override fun onPause() {
        super.onPause()
       // activity!!.setShowWhenLocked()
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            //  throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener from BottomSheet Historic")
        }
    }

    fun initWidgets(view: View) {
        noResults = view.noResults as LinearLayout
        noItems = view.noItems as LinearLayout
        noResultsQuery = noResults.findViewById(R.id.noResultsQuery)
        svSearch = view.svSearch
        cvSearch = view.cvSearch
        llBallance = view.findViewById(R.id.llBallance)
        tvHideBallance = view.findViewById(R.id.tvHideBallance)
        collapsingToolbarLayout = view.findViewById(R.id.clCollapsing)
        appBarLayout = view.findViewById(R.id.ablCollapse)
        shimmerContent = view.findViewById(R.id.shimmerContent)
        shimmerTv = view.findViewById(R.id.shimmerTv)
        shimmer = view.findViewById(R.id.shimmer_view_container) as ShimmerFrameLayout
        progress = view.findViewById(R.id.progress)

        mLayoutManager = LinearLayoutManager(activity)
        val typeface = ResourcesCompat.getFont(context!!, R.font.titillium_web_regular)
        etSearchHint = svSearch.findViewById(androidx.appcompat.R.id.search_src_text)
        etSearchHint.typeface = typeface
        svSearch.queryHint =
            Html.fromHtml("<font color = #CCCCCC>" + resources.getString(R.string.search_payments) + "</font>")

        setHome(this@HomeFragment)

        refreshLayout = view.findViewById(R.id.swipe_layout)

        refreshLayout.setColorSchemeColors(ContextCompat.getColor(context!!, R.color.colorPrimary))
        refreshLayout.setOnRefreshListener { getCards() }


        dots1 = view.findViewById(R.id.dots1)
        dots2 = view.findViewById(R.id.dots2)
        dots3 = view.findViewById(R.id.dots3)
        tvLasteNumber = view.findViewById(R.id.tvLastNumber)
        tvValidation = view.findViewById(R.id.tvValidation)
        tvNameUser = view.findViewById(R.id.tvNameUser)
        tvCardType = view.findViewById(R.id.tvCardType)
        tvValid = view.findViewById(R.id.tvValid)
        ivFlag = view.findViewById(R.id.ivFlag)
        bgCard = view.findViewById(R.id.bgCard)
        space1 = view.findViewById(R.id.space1)
        rlBlocked = view.findViewById(R.id.rlBlocked)
        rcHistoric = view.rvHistoricBottomSheet
        loader = view.findViewById(R.id.loading)

        tvHideBallance.setOnClickListener {
            preferencesRegister.saveShowCurrencyState(!showCur())
            verifyVisibilityViewsCollapsed()
        }

        appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            DebugSuperdigital.Log.i(TAG, "totalRange/ vertical= " + appBarLayout.totalScrollRange)
            when {
                verticalOffset == 0 -> setCurrentStateAndNotify(State.EXPANDED) {
                    DebugSuperdigital.Log.i(TAG, "EXPANDED/ vertical= $verticalOffset")
                    collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.ExpandedText)
                    if (!showCur()) {
                        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.HiddenText)
                    }
                    // refreshLayout.isRefreshing = true
                    refreshLayout.isEnabled = true
                }
                Math.abs(verticalOffset) >= appBarLayout.totalScrollRange -> setCurrentStateAndNotify(State.COLLAPSED) {
                    DebugSuperdigital.Log.i(TAG, "COLLAPSED/ vertical= $verticalOffset")
                    animateAppBar(0f)
                    collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedText)
                    if (!showCur()) {
                        collapsingToolbarLayout.title = resources.getString(R.string.app_name)
                    }
                    refreshLayout.isRefreshing = false
                    refreshLayout.isEnabled = false
                }
                else -> setCurrentStateAndNotify(State.IDLE) {
                    DebugSuperdigital.Log.i(TAG, "IDLE/ vertical= $verticalOffset")

                    animateAppBar(1.0f)
                    if (showCur()) {
                        setCurrencyTitle()
                        llBallance.visibility = View.VISIBLE
                        manageRvCoinVisibility()
                    } else {
                        collapsingToolbarLayout.title = resources.getString(R.string.app_name)
                        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.HiddenText)
                        llBallance.visibility = View.GONE
                    }
                    refreshLayout.isRefreshing = false
                    refreshLayout.isEnabled = false
                }
            }
        })


        svSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (::adapterHistoric.isInitialized) {
                    adapterHistoric.apply {
                        textFilter = newText ?: ""
                        agroupScreenList()
                    }
                    if (adapterHistoric.listScreen.isEmpty()) {
                        noResults.visibility = View.VISIBLE
                        noResultsQuery.visibility = View.VISIBLE
                        noResults.findViewById<TextView>(R.id.noResultsQuery).text =
                            String.format(resources.getString(R.string.no_result_query), newText)
                    } else {
                        noResults.visibility = View.INVISIBLE
                        noResultsQuery.visibility = View.INVISIBLE
                    }

                    if (newText.isNullOrEmpty()) {
                        noResults.visibility = View.INVISIBLE
                        noResultsQuery.visibility = View.INVISIBLE
                    }
                    return false
                } else {
                    noResultsQuery.visibility = View.INVISIBLE
                    listener!!.showHistoricEmptyForSearch()
                }
                return false
            }
        })

        val searchEditText = svSearch.findViewById(androidx.appcompat.R.id.search_src_text) as EditText
        searchEditText.typeface = ResourcesCompat.getFont(context!!, R.font.titillium_web_regular)
        searchEditText.setTextColor(ContextCompat.getColor(context!!, R.color.botombar_grey))
        searchEditText.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(30))
        searchEditText.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                //   home.shrink()
            }
        }
        searchEditText.setOnClickListener {
            // home.shrink()
        }
    }

    fun setCurrencyTitle() {
        if (1 > 0) {
            try {
                collapsingToolbarLayout.title =
                    if (showCur())
                        balance
                    else
                        resources.getString(R.string.app_name)
            } catch (e: Exception) {
                //  e.logCrashLytics()
                //    Log.d("HOME", "setTitleException: ${e.logCrashLytics()}")
            }
        } else {
            if (showCur())
                collapsingToolbarLayout.title = ""
        }
    }


    private fun showCur(): Boolean {
        return preferencesRegister.showingCurrencyState
    }


    private fun manageRvCoinVisibility() {
        if (activity == null || view == null) {
            return
        }

        var marginBottom = activity!!.pxFromDp(155f)

        val lp = shimmer.layoutParams
        lp.height = (activity!!.pxFromDp(162f))

        if (1 <= 1 || !showCur()) {
            marginBottom = activity!!.pxFromDp(75f)

            lp.height = (activity!!.pxFromDp(79f))
        }
        shimmer.layoutParams = lp

        collapsingToolbarLayout.expandedTitleMarginBottom = marginBottom

    }

    fun verifyVisibilityViewsCollapsed() {
        view ?: return

        if (mCurrentState != State.EXPANDED) {
            return
        }

        if (shimmerLoader) {
            shimmerContent.changeVisibity(View.GONE)
            shimmer.changeVisibity(View.VISIBLE)
        } else if (!showCur()) {
            tvHideBallance.text = resources.getString(R.string.show_balance)
            llBallance.changeVisibity(View.GONE)
            shimmer.changeVisibity(View.GONE)
            shimmerContent.changeVisibity(View.VISIBLE)

            collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.HiddenText)

        } else {
            setCurrencyTitle()
            tvHideBallance.text = resources.getString(R.string.hide_balance)
            llBallance.changeVisibity(View.VISIBLE)
            manageRvCoinVisibility()
            shimmer.changeVisibity(View.GONE)
            shimmerContent.changeVisibity(View.VISIBLE)

        }
    }

    private fun animateAppBar(value: Float) {
        cvSearch.animate().alpha(value).duration = 300
        tvHideBallance.animate().alpha(value).duration = 300

        cvSearch.isClickable = value == 1.0f
    }

    private fun setCurrentStateAndNotify(state: State, func: (() -> Unit)) {
        if (mCurrentState !== state) {
            mCurrentState = state
            verifyVisibilityViewsCollapsed()
            func()
        }
    }

    fun startShimmer(isFromTour: Boolean? = false) {
        shimmerLoader = true
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.HiddenText)
        shimmer.startShimmer()

        if (isFromTour!! || showCur()) {
            val lp = shimmer.layoutParams
            try {
                lp.height = (activity!!.pxFromDp(162f))
            } catch (e: Exception) {
            }
            shimmer.layoutParams = lp
        } else {
            collapsingToolbarLayout.refreshDrawableState()
        }
        verifyVisibilityViewsCollapsed()
    }

    fun stopShimmer() {
        shimmerLoader = false
        Handler().postDelayed({
            if (shimmer.isShimmerStarted) {
                shimmer.stopShimmer()
            }
            verifyVisibilityViewsCollapsed()
        }, 500)
    }

    override fun onItemClick(view: View, id: Long, type: Int, source: String) {

        //    view.preventDoubleClick()

        //  (activity as HomeActivity).showTransactionDetail(id, type.toLong(), source)
    }

    private fun getHistoric() {

        val today = Date()
        val startDate = Date().apply { sun(-90, Calendar.DAY_OF_MONTH) }

        noItems.visibility = View.GONE
        rcHistoric.visibility = View.GONE
        showLoader(getString(R.string.loading_transactions))


        SuperDigital.Builder((this@HomeFragment.activity as HomeActivity))
            .operation(
                OperationHistoric(
                    accountId = null,
                    endDate = today,
                    startDate = startDate,
                    skip = 0,
                    useCash = false,
                    take = Const.HISTORIC_LIMIT,
                    operationType = HistoryOperationType.all,
                    exchangeCurrency = Const.HISTORIC_EXCHANGE_CURRENCY
                )
            )
            .enqueue(object : SuperdigitalCallback<ResponseHistoric> {
                override fun onFailure(error: Error) {
                    if (view != null) {
                        hideLoader()
                        rcHistoric.visibility = View.GONE
                        noItems.visibility = View.VISIBLE
                    }
                }

                override fun onSuccess(response: ResponseHistoric) {
                    hideLoader()
                    refreshLayout.isRefreshing = false
                    if (response.moviments != null && response.moviments!!.isNotEmpty()) {
                        populateHistoric(response.moviments!!.toMutableList())
                        noItems.visibility = View.GONE
                        rcHistoric.visibility = View.VISIBLE
                    } else {
                        rcHistoric.visibility = View.GONE
                        noItems.visibility = View.VISIBLE
                    }
                }
            })
    }

    fun populateHistoric(histories: MutableList<ResponseHistoric.HistoricItem>) {
        try {
            adapterHistoric.updateListNotifyDataSetChange(histories)
            adapterHistoric.setMyClickListener(this)

            rcHistoric.apply {
                setHasFixedSize(true)
                layoutManager = mLayoutManager
                adapter = adapterHistoric
            }
            adapterHistoric.setMyClickListener(null)
        } catch (e: java.lang.Exception) {
            //   e.logCrashLytics()
        }
    }

    private fun getCards() {
        SuperDigital.Builder(activity!!)
            .operation(OperationCards())
            .enqueue(object : SuperdigitalCallback<ResponseCards> {
                override fun onSuccess(response: ResponseCards) {
                    if (view == null)
                        return

                    cards = (response.cards) ?: mutableListOf()

                    if (cards != null && cards!!.size > 0) {
                        cards?.let {
                            bind(it[0])
                            balance = it[0].availableLimit?.currencyFormat(it[0].currencySimbol) ?: ""
                            llBallance.text = balance
                        }
                        getHistoric()
                    }
                }

                override fun onFailure(error: Error) {
                    SDUtil.error = error

                    DebugSuperdigital.Log.e("ERROR", "Error: ${error.messages}")

                    if (error.code == 401) {
                        startActivity(
                            Intent(
                                (this@HomeFragment.activity as HomeActivity),
                                LoginActivity::class.java
                            ).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        )
                        (this@HomeFragment.activity as HomeActivity).finish()
                        return
                    }

                    activity?.showSB(
                        if (error.messages.isNotEmpty()) error.messages[0] else getString(R.string.generic_error2),
                        time = Toast.LENGTH_SHORT
                    )
                }
            })
    }

    private fun paintPurple() {
        bgCard.background = ContextCompat.getDrawable(this.context!!, R.drawable.bg_gradient_physic_card)
        ivFlag.setImageDrawable(ContextCompat.getDrawable(this.context!!, R.drawable.ic_mastercard))

        dots1.setTextColor(ContextCompat.getColor(this.context!!, R.color.white_transparent))
        dots2.setTextColor(ContextCompat.getColor(this.context!!, R.color.white_transparent))
        dots3.setTextColor(ContextCompat.getColor(this.context!!, R.color.white_transparent))
        tvLasteNumber.setTextColor(ContextCompat.getColor(this.context!!, R.color.white_transparent))
        tvValidation.setTextColor(ContextCompat.getColor(this.context!!, R.color.white_transparent))
        tvNameUser.setTextColor(ContextCompat.getColor(this.context!!, R.color.white_transparent))
        tvValid.setTextColor(ContextCompat.getColor(this.context!!, R.color.white_transparent))
        llBallance.setTextColor(ContextCompat.getColor(this.context!!, R.color.white_transparent))
        tvHideBallance.setTextColor(ContextCompat.getColor(this.context!!, R.color.white_transparent))
        tvCardType.setTextColor(ContextCompat.getColor(this.context!!, R.color.white))
        tvCardType.background = ContextCompat.getDrawable(this.context!!, R.drawable.stroke_white_transparent)
    }


    private fun paintWhite() {

        bgCard.background = ContextCompat.getDrawable(this.context!!, R.drawable.digital_card_bg)
        ivFlag.setImageDrawable(ContextCompat.getDrawable(this.context!!, R.drawable.ic_mastercard_black))
        dots1.setTextColor(ContextCompat.getColor(this.context!!, R.color.black))
        dots2.setTextColor(ContextCompat.getColor(this.context!!, R.color.black))
        dots3.setTextColor(ContextCompat.getColor(this.context!!, R.color.black))
        tvLasteNumber.setTextColor(ContextCompat.getColor(this.context!!, R.color.black))
        tvValidation.setTextColor(ContextCompat.getColor(this.context!!, R.color.black))
        tvNameUser.setTextColor(ContextCompat.getColor(this.context!!, R.color.gray))
        llBallance.setTextColor(ContextCompat.getColor(this.context!!, R.color.gray))
        tvHideBallance.setTextColor(ContextCompat.getColor(this.context!!, R.color.gray))
        tvValid.setTextColor(ContextCompat.getColor(this.context!!, R.color.gray))
        tvCardType.setTextColor(ContextCompat.getColor(this.context!!, R.color.colorPrimaryDark))
        tvCardType.background = ContextCompat.getDrawable(this.context!!, R.drawable.stroke_purple)
    }


    fun bind(card: RequestCard) {

        if (card.status == "20") {
            rlBlocked.visibility = View.VISIBLE
        } else {
            rlBlocked.visibility = View.GONE
        }

        when (card.type) {
            0 -> {
                paintPurple()
                tvCardType.text = context!!.getString(R.string.main_card)
                space1.visibility = View.VISIBLE
                tvValidation.text = SDUtil.parseDate(card.goodThrough!!, "yyyy-MM-dd'T'HH:mm:ss")!!.toString("MM/yy")

            }
            1 -> {
                paintPurple()
                tvCardType.text = context!!.getString(R.string.additional_card)
                space1.visibility = View.VISIBLE
                tvValidation.text = SDUtil.parseDate(card.goodThrough!!, "yyyy-MM-dd'T'HH:mm:ss")!!.toString("MM/yy")

            }
            3 -> {
                paintWhite()
                tvCardType.text = context!!.getString(R.string.virtual_card)
                space1.visibility = View.VISIBLE
                tvValidation.text = "**/**"
            }
        }

        tvLasteNumber.text = card.cardNumber!!.substring(card.cardNumber!!.lastIndexOf(" "))

        val name = if (card.ownerName != null) {
            card.ownerName!!.toUpperCase()
        } else if (card.cardName != null) {
            card.cardName!!.toUpperCase()
        } else {
            ""
        }
        tvNameUser.text = name

    }


    private fun showLoader(msg: String) {
        tvLoaderMsg.text = msg
        loader.visibility = View.VISIBLE
        progress.visibility = View.GONE
    }

    fun hideLoader() {
        loader.visibility = View.GONE
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            HomeFragment().apply {
            }
    }
}
