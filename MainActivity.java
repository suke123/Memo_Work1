package myproject.com.jp.todo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText editText;
	private Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// EditTextのIDをセットする
		setEditTextId();
		// ButtonのIDをセットする
		setButtonId();

		// ボタンをタップした時の処理
		// EditTextに入力した文字列を取得する
		getTextAndShowToastForClick();
	}

	/**
	 * ボタンを押した時にEditTextに入力されている文字を取得し、トースト表示メソッドに渡す。
	 */
	private void getTextAndShowToastForClick() {
		button.setOnClickListener(new View.OnClickListener() {
			// ボタンを押した時の処理
			@Override
			public void onClick(View v) {
				// EditTextに入力されて文字を取得する
				final String text = editText.getText().toString();
				// EditTextに文字が入力されていない場合は、Toastを表示しない
				if (!"".equals(text)) {
					// 入力した文字をToast表示する文字列として設定する
					setToastText(text);
				}
				editText.setText("");
			}
		});
	}

	/**
	 * ButtonのIDをセットする
	 */
	private void setButtonId() {
		button = findViewById(R.id.button);
	}

	/**
	 * EditTextのIDをセットする
	 */
	private void setEditTextId() {
		editText = findViewById(R.id.edit_text);
	}

	/**
	 * 入力した文字をToast表示する文字列として設定する。
	 *
	 * @param text 入力された文字列
	 */
	private void setToastText(final String text) {
		// messageTextに入力された文字列を代入する
		String messageText = text;
		// 入力された文字列が８文字より多い場合は、「８文字＋...」とする
		if (text.length() > 8) {
			// 入力された文字列の８文字目までを抽出し、その末尾を「...」とする
			messageText = text.substring(0, 8) + "...";
		}
		// Toastに出力する文字列を設定する
		// messageTextに「でログインしました」を追加する
		final String message = messageText + getString(R.string.toast_name2);
		// Toast文字列をshowToast()に渡す
		showToast(message);
	}

	/**
	 * Toastを表示する。
	 *
	 * @param message Toast表示文字列
	 */
	private void showToast(final String message) {
		final Toast toast = Toast.makeText(this, message, Toast.LENGTH_LONG);
		toast.show();
	}
}
