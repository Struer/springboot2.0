package com.imooc;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class TestController {

	@GetMapping("/1")
	private String get1() {
		log.info("get1 start");
		String result = createStr();
		log.info("get1 end.");
		return result;
	}

	@GetMapping("/2")
	private Mono<String> get2() {
		log.info("get2 start");
		Mono<String> result = Mono.fromSupplier(() -> createStr());
		log.info("get2 end.");
		return result;
	}
	/*
	 /1和/2请求的后端执行效率对比：/1(阻塞)用5.002s，/2(非阻塞)用0.002s
	 2019-05-04 23:58:35.321  INFO 17336 --- [ctor-http-nio-2] com.imooc.TestController                 : get1 start
	 2019-05-04 23:58:40.322  INFO 17336 --- [ctor-http-nio-2] com.imooc.TestController                 : get1 end.
	 2019-05-04 23:58:48.265  INFO 17336 --- [ctor-http-nio-2] com.imooc.TestController                 : get2 start
	 2019-05-04 23:58:48.267  INFO 17336 --- [ctor-http-nio-2] com.imooc.TestController                 : get2 end.
	 */

	/**
	 * Flux : 返回0-n个元素
	 * produces：指定流生产者的类型
	 * @return
	 */
	@GetMapping(value = "/3", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	private Flux<String> flux() {
		Flux<String> result = Flux
				.fromStream(IntStream.range(1, 5).mapToObj(i -> {
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
					}
					return "flux data--" + i;
				}));
		return result;
	}

	private String createStr() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
		}
		return "some string";
	}

}
