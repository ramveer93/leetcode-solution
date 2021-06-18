package javattest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		final Runnable command = () -> {
			System.out.println("---task is printing till 100");
			for (int i = 0; i < 100; i++) {
				System.out.println(i);

			}
		};
		//executor.execute(command);

		final Callable<String> callableCmd = () -> {
			return "Hellow";
		};

		Future<String> future = executor.submit(callableCmd);
		System.out.println(future.get());
		
		if (future.isDone()) {
			System.out.println("task done!!");
			try {
				System.out.println(future.get());
			} catch (InterruptedException e) {

				e.printStackTrace();
			} catch (ExecutionException e) {

				e.printStackTrace();
			}finally{
				executor.shutdown();
			}

		}

	}
}
