# component 模块简介
> 该模块示例了Android各种基本组件的使用方法
## 模块介绍
> AutoCompleteTextViewActivity:演示`AutoCompleteTextView`和`MultiAutoCompleteTextView`的使用方法
> ToggleButtonActivity:演示了`ToggleButton`的使用方法
> CheckBoxActivity：演示了`CheckBox`的使用方法
> RadioButtonActivity:演示了`RadioButton`的使用方法

## AutoCompleteTextView
### 功能
> 动态匹配输入内容

### 属性介绍
> `android:completionThreshold`：设置输入多少字符时自动匹配

## MultiAutoCompleteTextView
### 功能
> 动态匹配输入内容
> 支持多选（在多次输入的情况下），分布用分隔符分开，并且在每个值选中的时候再次输入值时会自动匹配，可用在发短信，邮件时选择联系人这种类型中。

### 属性介绍
> `android:completionThreshold`：设置输入多少字符时自动匹配

### 方法介绍
> `setTokenizer`：设置分隔符类型 例如：
```java 
	setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer())
```

## ToggleButton
### 功能
> `ToggleButton`有两种状态，选择状态和未选中状态，并且为不同状态设置不同的文本。

### 属性
> `android:checked`：`ToggleButton`的状态
> `android:textOff`：当`ToggleButton`的`checked`为false时显示的文本
> `android:textOn`：当`ToggleButton`的`checked`为true时显示的文本
### 方法
> `setOnCheckedChangeListener`：按钮点击事件。
### 适用场景
> `ToggleButton`适用于开关按钮，例如手电筒开关

## CheckBox
### 功能
> `CheckBox`是复选框，有两种状态，一是选中状态，二是未选中状态。 
### 属性
> `checked`：选中状态，选中值为true,未选中为false。默认为false。

## RadioButton
### 功能
> `RadioButton`是单选框，建议配合`RadioGroup`使用。`RadioGroup`是`RadioButton`的一个集合，提供多选一机制。
### 属性
#### RadioGroup属性
> `android:orientation`：决定`RadioButton`的排列方式，值为`vertical`和`horizontal`,默认`vertical`。
### 方法
> `setOnCheckedChangeListener`：监听`RadioGroup`内的`RadioButton`状态
