package com.example.media_app.chat.post

import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.media_app.R
import com.example.media_app.presentation.base.BaseFragment
import com.example.media_app.presentation.model.LoginModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.fragment_posts.*
import org.koin.android.ext.android.inject

class PostFragment : BaseFragment<PostViewModel>() {

    private lateinit var firestoreDb: FirebaseFirestore
    private lateinit var storageReference: StorageReference

    override val viewModel by inject<PostViewModel>()

    override fun getLayoutRes() = R.layout.fragment_posts

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.getUser(LoginModel("", ""))
//        viewModel.loadPostList()
        viewModel.postLiveData.observe(viewLifecycleOwner, Observer {
            val result = it
        })

//        storageReference = FirebaseStorage.getInstance().reference
//        firestoreDb = FirebaseFirestore.getInstance()
//
//        val postsReference = firestoreDb
//            .collection("posts")
//            .limit(20)
//            .orderBy("creation_time_ms", Query.Direction.DESCENDING)
//
//        postsReference.addSnapshotListener { querySnapshot, exception ->
//            if (exception != null) {
//                return@addSnapshotListener
//            }
//
//            val postList = querySnapshot?.toObjects(PostModel::class.java)
//
//            if (postList != null) {
//                for (post in postList) {
//                    val d = postList
//                }
//            }
//        }

        //---------------

        btn_create.setOnClickListener {
//            val photoReference = storageReference.child("images/${System.currentTimeMillis()}")
//            photoReference.putFile(Uri.EMPTY)
//                .continueWithTask { photoUploadTask ->
//                    photoReference.downloadUrl
//                }.continueWithTask { downloadUrlTask ->
//                    val post = PostModel(
//                        creationTimeMs = System.currentTimeMillis(),
//                        imageUrl = "https://www.vitalimages.com/wp-content/uploads/HIMSSHomeBanner2.jpg",
//                        description = "DESCR_4",
//                        user = UserModel(
//                            username = "NEW USER",
//                            age = 33
//                        )
//                    )
//                    firestoreDb.collection("posts").add(post)
//                }.addOnCompleteListener { postCreationTask ->
//                    if (!postCreationTask.isSuccessful) {
//                        val error = "error"
//                    } else {
//                        val success = "success"
//                    }
//                }

            //---------------
//            val taskData = hashMapOf<String, String>()
//            taskData["Field 1"] = "Value 1"
//            taskData["Field 2"] = "Value 2"
//
//            firestoreDb.collection("new")
//                .document("New Task")
//                .set(taskData)
//                .addOnSuccessListener {
//                    val success = it
//                }
//                .addOnFailureListener {
//                    val error = it
//                }
        }
    }
}