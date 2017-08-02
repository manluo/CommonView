## CommonView

#### 1. 自定义属性

|左边 |左边右侧 | 中间 | 右边左侧  | 右边|

<pre>
<code>
name="leftIcon" format="integer" 左边图标
name="leftRightDes" format="string" 左边右侧描述
name="rightIcon" format="integer" 右边图标
name="rightLeftDes" format="string" 右边左侧描述
name="leftRightDesColor" format="color" 左边右侧描述颜色
name="leftRightDesSize" format="dimension" 左边右侧描述文字大小
name="leftRightDesMarginLeft" format="dimension" 左边右侧描述离左侧图标==>左边距
name="rightLeftDesColor" format="color" 右边左侧描述颜色
name="rightLeftDesSize" format="dimension" 右边左侧描述文字大小
name="rightLeftDesMarginRight" format="dimension" 右边左侧描述离右侧图标==>右边距
name="middleDes" format="string" 中间文字描述
name="middleDesColor" format="color" 中间文字描述颜色
name="middleDesSize" format="dimension" 中间文字描述大小
name="isShowLine" format="boolean" 是否展示下划线 默认展示
name="showLineMarginLeft" format="dimension"  下划线离左屏幕距离
name="showLineMarginRight" format="dimension" 下划线离右屏幕距离
name="showLineSize" format="dimension" 下划线宽度
name="rightStyle" format="enum"
name="defaultStyle" value="0" 右边默认是图片
name="switchStyle" value="1" 右边是开关按钮
name="checkBoxStyle" value="2" 右边是checkbox按钮（可以使用自定义drawable替换）
name="checkboxCustomStyle" format="integer" 自定义drawable
</pre></code>
 ```
  <declare-styleable name="CommonRl">
        <attr name="leftIcon" format="integer" />
        <attr name="leftRightDes" format="string" />
        <attr name="rightIcon" format="integer" />
        <attr name="rightLeftDes" format="string" />
        <attr name="leftRightDesColor" format="color" />
        <attr name="leftRightDesSize" format="dimension" />
        <attr name="leftRightDesMarginLeft" format="dimension" />
        <attr name="rightLeftDesColor" format="color" />
        <attr name="rightLeftDesSize" format="dimension" />
        <attr name="rightLeftDesMarginRight" format="dimension" />
        <attr name="middleDes" format="string" />
        <attr name="middleDesColor" format="color" />
        <attr name="middleDesSize" format="dimension" />
        <attr name="isShowLine" format="boolean" />
        <attr name="showLineMarginLeft" format="dimension" />
        <attr name="showLineMarginRight" format="dimension" />
        <attr name="showLineSize" format="dimension" />
        <attr name="checkboxCustomStyle" format="integer" />
        <attr name="rightStyle" format="enum">
            <enum name="defaultStyle" value="0" />
            <enum name="switchStyle" value="1" />
            <enum name="checkBoxStyle" value="2" />
        </attr>
    </declare-styleable>
 
 ```




