# Examinator
Based on talk "Spring cloud goes cloud" / [Evgeny Borisov](https://github.com/Jeka1978) / [Alexander Barmin](https://github.com/aabarmin/aabarmin)

- [Youtube - Spring cloud goes cloud](https://github.com/aabarmin/aabarmin/blob/main/talks/2021/2021-spring-cloud-goes-cloud.pdf)
- [VK - Spring cloud goes cloud](https://vk.com/video-111905078_456247591)
- [slides](https://github.com/aabarmin/aabarmin/blob/main/talks/2021/2021-spring-cloud-goes-cloud.pdf)

After numerous attempts to repeat this work, the following has been implemented:

* `discovery-micro` - Service discovery with Eureka
* `exam-micro` - entry point, transparently sends requests to subsequent challenge providers
* `history-micro` - provides challenges about history
* `math-micro` - provides challenges about math

There was another module:
* `config-server` - Spring Cloud Config Server

But I did not quite understand why it was necessary, I did not delve into it)
I haven't been able to find a topic about the benefits of a configuration server yet.
Maybe it will work out later.

There are no K8s here either. It's simple project.

All urls are in the [file](insomnia_import.yaml) (export file from **insomnia 10.0**).

Access is open for ports:
*8761* (Eureka),
*8081* (Exam),
*8082* (History).