package io.github.onlyashd.bunny.ui.composable.settings

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import io.github.onlyashd.bunny.R
import io.github.onlyashd.bunny.books.BooksViewModel
import io.github.onlyashd.bunny.util.composable.colorScheme
import io.github.onlyashd.bunny.util.extensions.getString
import io.github.vinceglb.filekit.dialogs.FileKitMode
import io.github.vinceglb.filekit.dialogs.FileKitType
import io.github.vinceglb.filekit.dialogs.compose.rememberFilePickerLauncher

@Composable
fun FilePicker(booksViewModel: BooksViewModel = hiltViewModel()) {
    val context = LocalContext.current

    val launcher = rememberFilePickerLauncher(
        mode = FileKitMode.Multiple(),
        type = FileKitType.File(extensions = listOf("epub"))
    ) { files ->
        Log.i("FileSelector", files.toString())
        booksViewModel.saveBooks(files, context)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorScheme().background)
            .padding(8.dp)
    ) {
        Button(onClick = { launcher.launch() }) {
            Text(R.string.select_directory.getString())
        }

        HorizontalDivider()
    }
}