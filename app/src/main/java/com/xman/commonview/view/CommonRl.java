package com.xman.commonview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.SwitchCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xman.commonview.R;

/**
 * Created by nieyunlong on 17/7/26.
 */

public class CommonRl extends RelativeLayout implements CompoundButton.OnCheckedChangeListener {

    private static final String TAG = CommonRl.class.getSimpleName();

    private View mView;
    /*root*/
    private RelativeLayout mRootRl;
    /*左侧图标*/
    private ImageView mIvLeftIcon;
    /*左侧右边文字描述*/
    private TextView mTvLeftRightDes;
    /*右侧图片*/
    private ImageView mIvRightIcon;
    /*右侧左边文字描述*/
    private TextView mTvRightLeftDes;
    /*左侧图标*/
    private Drawable mLeftIcon;
    /*左侧右侧描述*/
    private String mLeftRightDes;
    /*右侧图标*/
    private Drawable mRightIcon;
    /*右侧左边文字描述*/
    private String mRightLeftDes;
    /*左侧右边文字的大小*/
    private float mLeftRightDesSize;
    /*左侧右边文字大小默认大小*/
    private float mleftRightDesSizeDefault = 14;
    /*左侧右边文字默认颜色*/
    private int leftRightDesColorDefault = Color.LTGRAY;
    /*左侧右边文字描述颜色*/
    private int mLeftRightDesColor;
    /*右侧左边文字大小*/
    private float mRightLeftDesSize;
    /*右侧左边文字颜色*/
    private int mRightLeftDesColor;
    /*右侧默认是图片*/
    private RelativeLayout mRlRightDefaultModel;
    /*右侧是开关*/
    private RelativeLayout mRlRightSwitchModel;
    /*默认是图片 1是开关模式*/
    private int mRightModel;
    /*开关view*/
    private SwitchCompat mSwitchCompat;

    private OnRightCheckListener onRightCheckListener;

    /*左侧点击事件*/
    private LinearLayout mllLeftRoot;

    /*右侧点击事件*/
    private RelativeLayout mFlRightContainer;
    /*中间描述 列如标题*/
    private RelativeLayout mRlMiddle;
    /*中间描述*/
    private TextView mTvMiddleDes;
    /*线*/
    private View mViewLine;
    /*checkbox*/
    private AppCompatCheckBox mCheckBox;


    public CommonRl(Context context) {
        this(context, null);
    }

    public CommonRl(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
        getAttributeSetAttrs(context, attrs);
        mHandlerListener(mRightModel);
    }


    /**
     * 初始化view
     *
     * @param context
     */
    private void initView(Context context) {
        mView = View.inflate(context, R.layout.item_common, this);
        mRootRl = (RelativeLayout) mView.findViewById(R.id.rl_root_common);
        mIvLeftIcon = (ImageView) mView.findViewById(R.id.iv_left_icon);
        mTvLeftRightDes = (TextView) mView.findViewById(R.id.tv_left_right_des);
        mIvRightIcon = (ImageView) mView.findViewById(R.id.iv_right_icon);
        mTvRightLeftDes = (TextView) mView.findViewById(R.id.tv_right_left_des);
        mRlRightDefaultModel = (RelativeLayout) mView.findViewById(R.id.rl_right_default_model);
        mRlRightSwitchModel = (RelativeLayout) mView.findViewById(R.id.rl_right_switch_model);
        mSwitchCompat = (SwitchCompat) mView.findViewById(R.id.switch_compat);
        mllLeftRoot = (LinearLayout) mView.findViewById(R.id.ll_left_root);
        mFlRightContainer = (RelativeLayout) mView.findViewById(R.id.fl_right_container);
        mRlMiddle = (RelativeLayout) mView.findViewById(R.id.rl_middle);
        mTvMiddleDes = (TextView) mView.findViewById(R.id.tv_middle_des);
        mCheckBox = (AppCompatCheckBox) mView.findViewById(R.id.checkbox);
        mViewLine = mView.findViewById(R.id.view_underline);
    }

    /**
     * 获取自定义属性
     *
     * @param context
     * @param attrs
     */
    private void getAttributeSetAttrs(Context context, AttributeSet attrs) {
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.CommonRl);
        int n = attributes.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = attributes.getIndex(i);
            Log.e(TAG, "===>getAttributeSetAttrs" + attr);
            setViewStyle(attr, attributes);
        }
        attributes.recycle();
        setRightModel(mRightModel); //解决不设置model 出现view全部出现问题
    }

    /**
     * 设置view属性
     *
     * @param attr
     * @param attributes
     */
    private void setViewStyle(int attr, TypedArray attributes) {
        switch (attr) {
            case R.styleable.CommonRl_leftIcon:
                mIvLeftIcon.setVisibility(View.VISIBLE);
                mLeftIcon = attributes.getDrawable(attr);
                mIvLeftIcon.setImageDrawable(mLeftIcon);
                break;
            case R.styleable.CommonRl_leftRightDes:
                mLeftRightDes = attributes.getString(attr);
                mTvLeftRightDes.setText(mLeftRightDes);
                break;
            case R.styleable.CommonRl_leftRightDesSize:
                mLeftRightDesSize = attributes.getDimension(attr, mleftRightDesSizeDefault);
                mTvLeftRightDes.setTextSize(TypedValue.COMPLEX_UNIT_PX, mLeftRightDesSize);
                break;
            case R.styleable.CommonRl_leftRightDesColor:
                mLeftRightDesColor = attributes.getColor(attr, leftRightDesColorDefault);
                mTvLeftRightDes.setTextColor(mLeftRightDesColor);
                break;
            case R.styleable.CommonRl_rightIcon:
                mRightIcon = attributes.getDrawable(attr);
                mIvRightIcon.setImageDrawable(mRightIcon);
                break;
            case R.styleable.CommonRl_rightLeftDes:
                mRightLeftDes = attributes.getString(attr);
                mTvRightLeftDes.setText(mRightLeftDes);
                break;
            case R.styleable.CommonRl_rightLeftDesSize:
                mRightLeftDesSize = attributes.getDimension(attr, mleftRightDesSizeDefault);
                mTvRightLeftDes.setTextSize(TypedValue.COMPLEX_UNIT_PX, mRightLeftDesSize);
                break;
            case R.styleable.CommonRl_rightLeftDesColor:
                mRightLeftDesColor = attributes.getColor(attr, leftRightDesColorDefault);
                mTvRightLeftDes.setTextColor(mRightLeftDesColor);
                break;
            case R.styleable.CommonRl_rightStyle:
                mRightModel = attributes.getInt(attr, 0);
                setRightModel(mRightModel);
                break;
            case R.styleable.CommonRl_leftRightDesMarginLeft: //左侧描述 距离左边的距离
                int leftMargin = (int) attributes.getDimension(attr, 0);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) mTvLeftRightDes.getLayoutParams();
                layoutParams.leftMargin = leftMargin;
                mTvLeftRightDes.setLayoutParams(layoutParams);
                break;
            case R.styleable.CommonRl_rightLeftDesMarginRight: //右侧描述 距离右边的距离
                int rightMargin = (int) attributes.getDimension(attr, 0);
                LayoutParams rightLeftMarginRightLayoutParams = (LayoutParams) mTvRightLeftDes.getLayoutParams();
                rightLeftMarginRightLayoutParams.rightMargin = rightMargin;
                mTvRightLeftDes.setLayoutParams(rightLeftMarginRightLayoutParams);
                break;
            case R.styleable.CommonRl_middleDes: //标题
                if (mRlMiddle.getVisibility() != View.VISIBLE) {
                    mRlMiddle.setVisibility(View.VISIBLE);
                }
                mTvMiddleDes.setText(attributes.getString(attr));
                break;
            case R.styleable.CommonRl_middleDesColor:
                int mMiddleDesColor = attributes.getColor(attr, leftRightDesColorDefault);
                mTvMiddleDes.setTextColor(mMiddleDesColor);
                break;
            case R.styleable.CommonRl_middleDesSize:
                float mMiddleDesSize = attributes.getDimension(attr, mleftRightDesSizeDefault);
                mTvMiddleDes.setTextSize(TypedValue.COMPLEX_UNIT_PX, mMiddleDesSize);
                break;
            case R.styleable.CommonRl_isShowLine: //是否展示布局下边的线
                boolean isShowLine = attributes.getBoolean(attr, true); //默认是展示
                if (isShowLine) {
                    mViewLine.setVisibility(View.VISIBLE);
                } else {
                    mViewLine.setVisibility(View.GONE);
                }
                break;
            case R.styleable.CommonRl_showLineMarginLeft: //线的左边距
                int showLineMarginLeft = (int) attributes.getDimension(attr, 0);
                LayoutParams lineParams = (LayoutParams) mViewLine.getLayoutParams();
                lineParams.leftMargin = showLineMarginLeft;
                mViewLine.setLayoutParams(lineParams);
                break;
            case R.styleable.CommonRl_showLineMarginRight: //线的右边距
                int showLineMarginRight = (int) attributes.getDimension(attr, 0);
                LayoutParams lineMarginParams = (LayoutParams) mViewLine.getLayoutParams();
                lineMarginParams.rightMargin = showLineMarginRight;
                mViewLine.setLayoutParams(lineMarginParams);
                break;
            case R.styleable.CommonRl_showLineSize: //线的大小
                int showLineSize = (int) attributes.getDimension(attr, 1);
                LayoutParams heightLineParams = (LayoutParams) mViewLine.getLayoutParams();
                heightLineParams.height = showLineSize;
                mViewLine.setLayoutParams(heightLineParams);
                break;
            case R.styleable.CommonRl_checkboxCustomStyle: //Checkbox 样式
                Drawable checkBoxDrawable = attributes.getDrawable(attr);
                mCheckBox.setButtonDrawable(null);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    mCheckBox.setBackground(checkBoxDrawable);
                } else {
                    mCheckBox.setBackgroundDrawable(checkBoxDrawable);
                }
                break;
        }
    }

    /**
     * 根据模式处理listener
     *
     * @param mRightModel
     */
    private void mHandlerListener(int mRightModel) {
        if (mRightModel == 1) { //开关模式
            mSwitchCompat.setOnCheckedChangeListener(this);
        } else if (mRightModel == 2) { //checkbox 模式
            mCheckBox.setOnCheckedChangeListener(this);
        }
    }


    /**
     * @param mRightModel 0是默认模式 图片 1是开关模式
     */
    private void setRightModel(int mRightModel) {
        switch (mRightModel) {
            case 0: //图片展示
                mRlRightDefaultModel.setVisibility(View.VISIBLE);
                mRlRightSwitchModel.setVisibility(View.GONE);
                mCheckBox.setVisibility(View.GONE);
                break;
            case 1: //开关模式
                mRlRightDefaultModel.setVisibility(View.GONE);
                mRlRightSwitchModel.setVisibility(View.VISIBLE);
                mCheckBox.setVisibility(View.GONE);
                break;
            case 2: //checkbox 模式
                mCheckBox.setVisibility(View.VISIBLE);
                mRlRightDefaultModel.setVisibility(View.GONE);
                mRlRightSwitchModel.setVisibility(View.GONE);
                break;
        }
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Log.e(TAG, "---->onCheckedChanged" + isChecked + ",id" + buttonView.getId());
        if (buttonView.getId() == R.id.switch_compat) { //开关模式
            if (onRightCheckListener != null) {
                onRightCheckListener.onCheck(isChecked);
            }
        } else if (buttonView.getId() == R.id.checkbox) {
            if (onRightCheckListener != null) {
                onRightCheckListener.onCheck(isChecked);
            }
        }
    }

    /**
     * 整个条目点击事件
     *
     * @param onClickListener
     */
    public void setOnItemClickListener(OnClickListener onClickListener) {
        mRootRl.setOnClickListener(onClickListener);
    }

    /**
     * 左侧点击事件
     *
     * @param onClickListener
     */
    public void setLeftOnClickListener(OnClickListener onClickListener) {
        mllLeftRoot.setOnClickListener(onClickListener);
    }

    /**
     * 右侧check选择事件
     * CommonRelativeLayout:rightStyle 不是default 模式 才生效
     *
     * @param onRightCheckListener
     */
    public void setRightCheckListener(OnRightCheckListener onRightCheckListener) {
        this.onRightCheckListener = onRightCheckListener;
    }

    /**
     * 右侧点击事件
     *
     * @param onClickListener
     */
    public void setRightOnClickListener(OnClickListener onClickListener) {
        mFlRightContainer.setOnClickListener(onClickListener);
    }

    /**
     * 中间点击事件
     *
     * @param onClickListener
     */
    public void setMiddleOnClickListener(OnClickListener onClickListener) {
        mRlMiddle.setOnClickListener(onClickListener);
    }

    /**
     * 设置root高度
     *
     * @param height
     */
    public void setRootHeight(int height) {
        LayoutParams layoutParams = (LayoutParams) mRootRl.getLayoutParams();
        layoutParams.height = height;
        mRootRl.setLayoutParams(layoutParams);
    }

    /**
     * 本地图片资源
     *
     * @param resId
     */
    public void setLeftIcon(int resId) {
        mIvLeftIcon.setImageResource(resId);
    }

    /**
     * @param bitmap
     */
    public void setLeftIcon(Bitmap bitmap) {
        if (bitmap == null) return;
        mIvLeftIcon.setImageBitmap(bitmap);
    }

    /**
     * @param drawable
     */
    public void setLeftIcon(Drawable drawable) {
        if (drawable == null) return;
        mIvLeftIcon.setImageDrawable(drawable);
    }

    public void setLeftRightDes(String des) {
        if (TextUtils.isEmpty(des)) return;
        mTvLeftRightDes.setText(des);
    }

    public void setLeftRightDes(float tvSize) {
        mTvLeftRightDes.setTextSize(tvSize);
    }

    public void setLeftRightDes(int tvSize) {
        mTvLeftRightDes.setTextSize(tvSize);
    }

    public void setLeftRightColor(int leftRightColor) {
        mTvLeftRightDes.setTextColor(leftRightColor);
    }

    public interface OnRightCheckListener {
        void onCheck(boolean isCheck);
    }

}
