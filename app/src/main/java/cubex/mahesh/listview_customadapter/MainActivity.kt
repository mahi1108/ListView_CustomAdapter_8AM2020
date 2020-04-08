package cubex.mahesh.listview_customadapter

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var status = ContextCompat.checkSelfPermission(
            this@MainActivity,
            Manifest.permission.WRITE_EXTERNAL_STORAGE)
        if(status == PackageManager.PERMISSION_GRANTED){
            readFiles();
        }else{
            ActivityCompat.requestPermissions(
                this@MainActivity,
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                11)
        }
    } // oncreate

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray) {
        super.onRequestPermissionsResult(
            requestCode, permissions, grantResults)
        if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
        {
            readFiles()
        }else{
            finish()
        }
    } // onRequestPermissionsResult

    fun readFiles(){
        var path = "/storage/emulated/0/DCIM/Screenshots"
        var f:File = File(path)
        var files = f.list()
        var myAdapter = MyAdapter(path,files)
    } // readFiles
}
