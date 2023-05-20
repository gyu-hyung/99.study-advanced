package hello.advanced.app.v5;

import hello.advanced.trace.callback.TraceCallback;
import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceV5 {
    private final OrderRepositoryV5 orderRepositoryV5;
    private final TraceTemplate template;


    public OrderServiceV5(OrderRepositoryV5 orderRepositoryV5, LogTrace trace) {
        this.orderRepositoryV5 = orderRepositoryV5;
        this.template = new TraceTemplate(trace);
    }


    public void orderItem(String itemId){
        template.execute("OrderService.orderItem()", () -> {
            orderRepositoryV5.save(itemId);
            return null;
        });
    }
}



//    public void orderItem(String itemId){ @익명클래스 방법
//        template.execute("OrderService.orderItem()", new TraceCallback<Object>() {
//            @Override
//            public Void call() {
//                orderRepositoryV5.save(itemId);
//                return null;
//            }
//        });
//    }
