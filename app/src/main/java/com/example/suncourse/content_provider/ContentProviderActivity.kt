package com.example.suncourse.content_provider

import android.Manifest
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.suncourse.databinding.ActivityContentProviderBinding

class ContentProviderActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityContentProviderBinding.inflate(layoutInflater)
    }

    private val requestPermission =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGrant ->
            if (isGrant) {
                getContact()
            }
            else {
                Toast.makeText(this@ContentProviderActivity, "NOT GRANT", Toast.LENGTH_SHORT).show()
            }
        }

    private val contactList = mutableListOf<ContactItem>()
    private lateinit var adapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        requestPermission.launch(Manifest.permission.READ_CONTACTS)

    }

    private fun getContact() {
        val uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI
        val projection = arrayOf(
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.NUMBER,
            ContactsContract.CommonDataKinds.Phone.PHOTO_THUMBNAIL_URI
        )
        Toast.makeText(this@ContentProviderActivity, "HERE", Toast.LENGTH_SHORT).show()
        contentResolver.query(uri, projection, null, null, null)?.use {
            if (it.count > 0) {
                val nameIndex =
                    it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
                val phoneIndex = it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
                val photoIndex =
                    it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_THUMBNAIL_URI)

                while (it.moveToNext()) {
                    val contact = ContactItem(
                        it.getString(nameIndex),
                        it.getString(phoneIndex),
                        it.getString(photoIndex)?.let { uriString ->
                            Uri.parse(uriString)
                        }
                    )
                    contactList.add(contact)
                    Toast.makeText(this@ContentProviderActivity, it.getString(nameIndex), Toast.LENGTH_SHORT).show()
                }
            }
        }
        binding.apply {
            adapter = ContactAdapter(contactList)
            rvContact.layoutManager = LinearLayoutManager(this@ContentProviderActivity)
            rvContact.adapter = adapter
        }
    }

}