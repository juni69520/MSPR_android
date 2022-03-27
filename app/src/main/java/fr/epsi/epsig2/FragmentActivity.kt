package fr.epsi.epsig2

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class FragmentActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout_fragment)

        showProfileTab()
    }

    private fun showProfileTab() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.contentLayout, ProfileTabFragment::class.java, null)
        transaction.setReorderingAllowed(true)
        transaction.addToBackStack("aB") // name can be null
        transaction.commit()
    }

    override fun onBackPressed() {
        if(supportFragmentManager.backStackEntryCount>1)
            super.onBackPressed()
        else
            finish()
    }
}