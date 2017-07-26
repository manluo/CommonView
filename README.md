#CommonView

在布局中加命名空间

xmlns:CommonRelativeLayout="http://schemas.android.com/apk/res-auto"

<com.xman.commonview.view.CommonRl
  android:id="@+id/crl_my_item_one"
  android:layout_width="match_parent"
  android:layout_height="wrap_content"
  CommonRelativeLayout:leftIcon="@drawable/checked"
  CommonRelativeLayout:leftRightDes="@string/app_name"
  CommonRelativeLayout:leftRightDesColor="@color/colorPrimary"
  CommonRelativeLayout:leftRightDesMarginLeft="20dp"
  CommonRelativeLayout:leftRightDesSize="16sp"
  CommonRelativeLayout:rightStyle="switchStyle" />


