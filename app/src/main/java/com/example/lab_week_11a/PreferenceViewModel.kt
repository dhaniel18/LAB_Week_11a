package com.example.lab_week_11a

class PreferenceViewModel(private val preferenceWrapper: PreferenceWrapper)
    : ViewModel() {
    // Save the text to the shared preferences
    fun saveText(text: String) {
        preferenceWrapper.saveText(text)
    }
    // Get the text from the shared preferences
    fun getText(): LiveData<String> {
        return preferenceWrapper.getText()
    }
}
