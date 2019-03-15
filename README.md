#### HM-Pay

集成纸质借条模版和纸质收条模版

#### 功能介绍
- 纸质借条模版
- 纸质收条模版


#### 安装

在工程根目录的build.gradle文件里添加如下maven地址：

```gradle
allprojects {
    repositories {
        ...
        maven { url 'file:///Users/syl/.m2/repository/' }
        ...
    }
}
```

在项目模块的buile.gradle文件里面加入如下依赖：

```gradle
    compile 'com.heima.iou:hmtemplatelocal:1.0.0'
```

外部引用：

```gradle
    compile 'com.heima.iou:hmbasebizlocal:1.0.0'
```

#### 使用说明

支持的路由

| 页面 | 路由url | 备注 |
| ------ | ------ | ------ |
| 模版类型选择页面 | ```hmiou://m.54jietiao.com/template/select_type```|  |
| 纸质借条模版页面 | ```hmiou://m.54jietiao.com/template/paper_borrow?show_include=*``` | show_include为"true"，则显示收录页，其他情况都不显示 |
| 纸质收条模版页面 | ```hmiou://m.54jietiao.com/template/paper_receive?show_include=*``` | show_include为"true"，则显示收录页，其他情况都不显示 |

路由文件

```json
{
  "template": [
    {
      "url": "hmiou://m.54jietiao.com/template/select_type",
      "iclass": "",
      "aclass": "com.hm.iou.template.business.TemplateIndexActivity"
    },
    {
      "url": "hmiou://m.54jietiao.com/template/paper_borrow?show_include=*",
      "iclass": "",
      "aclass": "com.hm.iou.template.business.borrow.PaperBorrowTemplateActivity"
    },
    {
      "url": "hmiou://m.54jietiao.com/template/paper_receive?show_include=*",
      "iclass": "",
      "aclass": "com.hm.iou.template.business.receive.PaperReceiveTemplateActivity"
    }
  ]
}
```

#### 集成说明

集成本模块之前，需要保证一下模块已经初始化：

HM-BaseBiz初始化(基础业务模块)，HM-Network（网络框架），HM-Router（路由模块），Logger（日志记录）

#### Author

syl