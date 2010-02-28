package com.caveda.examples.copypaste;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;


public class CopyPasteMain extends Activity implements OnClickListener{

	private static String TAG="CopyPasteMain";
	private View copyButton;
	private View pasteButton;
	private EditText editCopy;
	private EditText editPaste;

	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setUpViews();
       
    }

    // Retrieve Views and Setup Listeners
    private void setUpViews() 
    {
    	// Initializing Views References
    	copyButton = findViewById(R.id.ButtonCopy);
		pasteButton = findViewById(R.id.ButtonPaste);
		editCopy = (EditText) findViewById(R.id.EditCopy);
		editPaste = (EditText) findViewById(R.id.EditPaste);
		
		// Establishing listeners for buttons
		copyButton.setOnClickListener(this);
		pasteButton.setOnClickListener(this);
	}

    
    
    // Retrieve Views and Setup Listeners
    public void onClick (View v) 
    {
		switch (v.getId())
		{
			case R.id.ButtonCopy:
				copyToClipBoard();
				break;
			case R.id.ButtonPaste:
				pasteFromClipBoard();
				break;
			default:
				Log.d(TAG, "OnClick: Unknown View Received!");
				break;
		}
	}

    // Copy EditCopy text to the ClipBoard
	private void copyToClipBoard() 
	{
		ClipboardManager ClipMan = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
		ClipMan.setText(editCopy.getText());
	}
    
	
	// Paste ClipBoard Text to EditPaste
	private void pasteFromClipBoard() 
	{
		ClipboardManager ClipMan = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
		editPaste.setText(ClipMan.getText());
	}

}