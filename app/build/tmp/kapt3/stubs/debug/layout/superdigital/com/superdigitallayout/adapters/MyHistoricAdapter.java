package layout.superdigital.com.superdigitallayout.adapters;

import java.lang.System;

/**
 * * @author Mario Guerra on 10/07/2019
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003789B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0006\u0010\'\u001a\u00020(J\u0012\u0010)\u001a\u00020(2\b\b\u0002\u0010*\u001a\u00020\"H\u0002J\b\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020,H\u0016J\u0018\u0010/\u001a\u00020(2\u0006\u00100\u001a\u00020\u00022\u0006\u0010.\u001a\u00020,H\u0016J\u0018\u00101\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u00102\u001a\u00020,H\u0016J\u0010\u00103\u001a\u00020(2\b\u00104\u001a\u0004\u0018\u00010\u0005J\u0014\u00105\u001a\u00020(2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u0006:"}, d2 = {"Llayout/superdigital/com/superdigitallayout/adapters/MyHistoricAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "()V", "clickListener", "Llayout/superdigital/com/superdigitallayout/adapters/MyHistoricAdapter$ItemClickListener;", "getClickListener", "()Llayout/superdigital/com/superdigitallayout/adapters/MyHistoricAdapter$ItemClickListener;", "setClickListener", "(Llayout/superdigital/com/superdigitallayout/adapters/MyHistoricAdapter$ItemClickListener;)V", "ivIn", "Landroid/graphics/drawable/Drawable;", "ivOut", "listFiltred", "", "Lsuperdigital/com/superdigitalotp/operations/responses/ResponseHistoric$HistoricItem;", "getListFiltred", "()Ljava/util/List;", "setListFiltred", "(Ljava/util/List;)V", "listFull", "getListFull", "setListFull", "listScreen", "", "getListScreen", "setListScreen", "parent", "Landroid/view/ViewGroup;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "textFilter", "", "getTextFilter", "()Ljava/lang/String;", "setTextFilter", "(Ljava/lang/String;)V", "agroupScreenList", "", "filter", "text", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "viewType", "setMyClickListener", "itemClickListener", "updateListNotifyDataSetChange", "list", "DateViewHolder", "HistoricViewHolder", "ItemClickListener", "app_debug"})
public final class MyHistoricAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.List<superdigital.com.superdigitalotp.operations.responses.ResponseHistoric.HistoricItem> listFull;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<superdigital.com.superdigitalotp.operations.responses.ResponseHistoric.HistoricItem> listFiltred;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.Object> listScreen;
    private android.graphics.drawable.Drawable ivIn;
    private android.graphics.drawable.Drawable ivOut;
    @org.jetbrains.annotations.NotNull()
    public android.view.ViewGroup parent;
    @org.jetbrains.annotations.NotNull()
    public layout.superdigital.com.superdigitallayout.adapters.MyHistoricAdapter.ItemClickListener clickListener;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String textFilter;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<superdigital.com.superdigitalotp.operations.responses.ResponseHistoric.HistoricItem> getListFull() {
        return null;
    }
    
    public final void setListFull(@org.jetbrains.annotations.NotNull()
    java.util.List<superdigital.com.superdigitalotp.operations.responses.ResponseHistoric.HistoricItem> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<superdigital.com.superdigitalotp.operations.responses.ResponseHistoric.HistoricItem> getListFiltred() {
        return null;
    }
    
    public final void setListFiltred(@org.jetbrains.annotations.NotNull()
    java.util.List<superdigital.com.superdigitalotp.operations.responses.ResponseHistoric.HistoricItem> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Object> getListScreen() {
        return null;
    }
    
    public final void setListScreen(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Object> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.ViewGroup getParent() {
        return null;
    }
    
    public final void setParent(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final layout.superdigital.com.superdigitallayout.adapters.MyHistoricAdapter.ItemClickListener getClickListener() {
        return null;
    }
    
    public final void setClickListener(@org.jetbrains.annotations.NotNull()
    layout.superdigital.com.superdigitallayout.adapters.MyHistoricAdapter.ItemClickListener p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public int getItemViewType(int position) {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position) {
    }
    
    public final void updateListNotifyDataSetChange(@org.jetbrains.annotations.NotNull()
    java.util.List<superdigital.com.superdigitalotp.operations.responses.ResponseHistoric.HistoricItem> list) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTextFilter() {
        return null;
    }
    
    public final void setTextFilter(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    private final void filter(java.lang.String text) {
    }
    
    public final void agroupScreenList() {
    }
    
    public final void setMyClickListener(@org.jetbrains.annotations.Nullable()
    layout.superdigital.com.superdigitallayout.adapters.MyHistoricAdapter.ItemClickListener itemClickListener) {
    }
    
    public MyHistoricAdapter() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Llayout/superdigital/com/superdigitallayout/adapters/MyHistoricAdapter$DateViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Llayout/superdigital/com/superdigitallayout/adapters/MyHistoricAdapter;Landroid/view/View;)V", "getView", "()Landroid/view/View;", "bind", "", "date", "", "app_debug"})
    public final class DateViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.view.View view = null;
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        java.lang.String date) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.view.View getView() {
            return null;
        }
        
        public DateViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u000e\u0010&\u001a\u00020\'2\u0006\u0010\u0006\u001a\u00020\u0007J\u0012\u0010(\u001a\u00020\'2\b\u0010)\u001a\u0004\u0018\u00010\u0004H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001a\u0010\u001b\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001a\u0010\u001e\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R\u001a\u0010!\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%\u00a8\u0006*"}, d2 = {"Llayout/superdigital/com/superdigitallayout/adapters/MyHistoricAdapter$HistoricViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "view", "Landroid/view/View;", "(Llayout/superdigital/com/superdigitallayout/adapters/MyHistoricAdapter;Landroid/view/View;)V", "historic", "Lsuperdigital/com/superdigitalotp/operations/responses/ResponseHistoric$HistoricItem;", "getHistoric", "()Lsuperdigital/com/superdigitalotp/operations/responses/ResponseHistoric$HistoricItem;", "setHistoric", "(Lsuperdigital/com/superdigitalotp/operations/responses/ResponseHistoric$HistoricItem;)V", "ivIcon", "Landroid/widget/ImageView;", "getIvIcon", "()Landroid/widget/ImageView;", "setIvIcon", "(Landroid/widget/ImageView;)V", "tvDate", "Landroid/widget/TextView;", "getTvDate", "()Landroid/widget/TextView;", "setTvDate", "(Landroid/widget/TextView;)V", "tvDescription", "getTvDescription", "setTvDescription", "tvSource", "getTvSource", "setTvSource", "tvType", "getTvType", "setTvType", "tvValue", "getTvValue", "setTvValue", "getView", "()Landroid/view/View;", "bind", "", "onClick", "v", "app_debug"})
    public final class HistoricViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder implements android.view.View.OnClickListener {
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView tvValue;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView tvDescription;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView tvDate;
        @org.jetbrains.annotations.NotNull()
        private android.widget.ImageView tvType;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView tvSource;
        @org.jetbrains.annotations.NotNull()
        private android.widget.ImageView ivIcon;
        @org.jetbrains.annotations.Nullable()
        private superdigital.com.superdigitalotp.operations.responses.ResponseHistoric.HistoricItem historic;
        @org.jetbrains.annotations.NotNull()
        private final android.view.View view = null;
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvValue() {
            return null;
        }
        
        public final void setTvValue(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvDescription() {
            return null;
        }
        
        public final void setTvDescription(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvDate() {
            return null;
        }
        
        public final void setTvDate(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getTvType() {
            return null;
        }
        
        public final void setTvType(@org.jetbrains.annotations.NotNull()
        android.widget.ImageView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvSource() {
            return null;
        }
        
        public final void setTvSource(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getIvIcon() {
            return null;
        }
        
        public final void setIvIcon(@org.jetbrains.annotations.NotNull()
        android.widget.ImageView p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final superdigital.com.superdigitalotp.operations.responses.ResponseHistoric.HistoricItem getHistoric() {
            return null;
        }
        
        public final void setHistoric(@org.jetbrains.annotations.Nullable()
        superdigital.com.superdigitalotp.operations.responses.ResponseHistoric.HistoricItem p0) {
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        superdigital.com.superdigitalotp.operations.responses.ResponseHistoric.HistoricItem historic) {
        }
        
        @java.lang.Override()
        public void onClick(@org.jetbrains.annotations.Nullable()
        android.view.View v) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.view.View getView() {
            return null;
        }
        
        public HistoricViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\f"}, d2 = {"Llayout/superdigital/com/superdigitallayout/adapters/MyHistoricAdapter$ItemClickListener;", "", "onItemClick", "", "view", "Landroid/view/View;", "id", "", "type", "", "source", "", "app_debug"})
    public static abstract interface ItemClickListener {
        
        public abstract void onItemClick(@org.jetbrains.annotations.NotNull()
        android.view.View view, long id, int type, @org.jetbrains.annotations.NotNull()
        java.lang.String source);
    }
}