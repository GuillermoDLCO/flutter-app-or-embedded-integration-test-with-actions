package com.android.app.example

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.android.app.example.databinding.ActivityMainBinding
import io.flutter.embedding.android.FlutterFragment
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val flutterEngineIdMainActivity = "engineMainActivity"
    private val tagFlutterFragment = "flutterFragment"
    private var flutterFragment: FlutterFragment? = null
    private val handler: Handler = Handler(Looper.getMainLooper())


    override fun onCreate(savedInstanceState: Bundle?) {
        
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            val engine = FlutterEngine(this)
            engine.dartExecutor.executeDartEntrypoint(DartExecutor.DartEntrypoint.createDefault())

            FlutterEngineCache.getInstance().put(flutterEngineIdMainActivity, engine)

            val fragmentManager: FragmentManager = supportFragmentManager
            // Attempt to find an existing FlutterFragment, in case this is not the
            // first time that onCreate() was run.
            flutterFragment = fragmentManager.findFragmentByTag(tagFlutterFragment) as FlutterFragment?

            // Create and attach a FlutterFragment if one does not exist.
            if (flutterFragment == null) {
                val newFlutterFragment: FlutterFragment =
                    FlutterFragment.withCachedEngine(flutterEngineIdMainActivity)
                        .build()
                flutterFragment = newFlutterFragment
                fragmentManager.beginTransaction().add(
                    R.id.flFlutterFragment, newFlutterFragment, tagFlutterFragment
                ).commit()
            }
       
    }

    override fun onPostResume() {
        super.onPostResume()
        flutterFragment!!.onPostResume()
    }

    @SuppressLint("MissingSuperCall")
    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        flutterFragment!!.onNewIntent(intent)
    }

    override fun onBackPressed() {
        flutterFragment!!.onBackPressed()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        flutterFragment!!.onRequestPermissionsResult(
            requestCode,
            permissions,
            grantResults
        )
    }

    override fun onUserLeaveHint() {
        flutterFragment!!.onUserLeaveHint()
    }

    @SuppressLint("MissingSuperCall")
    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        flutterFragment!!.onTrimMemory(level)
    }

    override fun onDestroy() {
        handler.removeCallbacksAndMessages(null)
        super.onDestroy()
    }
}