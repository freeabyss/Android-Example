## AutoCompleteTextView简介
### 功能
> 动态匹配输入内容

### 属性介绍
> `android:completionThreshold`：设置输入多少字符时自动匹配

## MultiAutoCompleteTextView 简介
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

## ToggleButton 简介
### 功能
> `ToggleButton`有两种状态，选择状态和未选中状态，并且为不同状态设置不同的文本。

### 属性
> `android:checked`：`ToggleButton`的状态
> `android:textOff`：当`ToggleButton`的`checked`为false时显示的文本
> `android:textOn`：当`ToggleButton`的`checked`为true时显示的文本
