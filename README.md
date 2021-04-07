
[![Build Status](https://travis-ci.org/las-asdx/scala_ci.svg?branch=main)](https://travis-ci.org/las-asdx/scala_ci)
[![Coverage Status](https://coveralls.io/repos/github/las-asdx/scala_ci/badge.svg?branch=main)](https://coveralls.io/github/las-asdx/scala_ci?branch=main)

# 代码质量

##  单元测试

### scala test

#### ScalaTest的测试风格

  ScalaTest一共提供了七种测试风格，分别为：FunSuite，FlatSpec，FunSpec，WordSpec，FreeSpec，PropSpec和FeatureSpec。
  
  FunSpec则通过提供诸如it、should、describe等方法，来规定书写测试的一种模式，例如前者明显的“主-谓-宾”结构，后者清晰的分级式结构，都可以使团队的测试更加规范。
```
//FunSpec
import org.scalatest.FunSpec

class SetSpec extends FunSpec {
  describe("A Set") {
      describe("when empty") {
          it("should have size 0") {
              assert(Set.empty.size == 0)
          }
          it("should produce NoSuchElementException when head is invoked") {
              intercept[NoSuchElementException] {
                  Set.empty.head
              }
          }
      }
  }
}
```
### scala mock

[ScalaMock](https://scalamock.org/user-guide/)

ScalaMock支持3种不同的模拟风格：

- 函数模拟（Function mocks）
- 代理（动态）模拟（Proxy (dynamic) mocks）
- 生成类型安全模拟（Generated (type-safe) mocks）

#### mock db
    
  通过H2内存数据库，mock数据库操作

#### mock redis

  通过embedded redisServer 实现mock 一个localhost的redis server，方便写单元测试

#### mock kafka

  通过embedded-kafka，mock kafka操作

## 测试覆盖率（Test Coverage）

### Codecov VS Coveralls
    
  Codecov和Coveralls大同小异。 但在文档&技术支持上，codecov做得更好。codecov获得了很多大公司的支持（雅虎、google cloud、docker、amazon、facebook、twitter）
  
  demo
- https://github.com/las-asdx/scala_ci/pull/2
- coverall https://coveralls.io/github/las-asdx/scala_ci
- codecov https://codecov.io/gh/las-asdx/scala_ci

### 测试覆盖率多少算好？

  测试覆盖率是非常有用的工具，可以找到没有测试的代码。但在充当一个数字统计，或者告诉别人你的测试做的有多么好上，测试覆盖率没有太大的用途。

  80%-90%之间（任何测试覆盖率达到100%的项目，会有一种写测试是为了提高测试覆盖率）

### Code Review和检测

https://codeclimate.com/
    
# 持续集成

https://aws.amazon.com/cn/blogs/containers/create-a-ci-cd-pipeline-for-amazon-ecs-with-github-actions-and-aws-codebuild-tests/


