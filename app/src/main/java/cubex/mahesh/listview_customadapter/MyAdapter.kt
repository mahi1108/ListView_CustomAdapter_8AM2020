package cubex.mahesh.listview_customadapter

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class MyAdapter(var path:String,
                var files:Array<String>):BaseAdapter() {
    override fun getView(position: Int, convertView: View?,
                         parent: ViewGroup?): View {

    }

    override fun getItem(position: Int): Any = 0

    override fun getItemId(position: Int): Long = 0

    override fun getCount(): Int = files.size

}