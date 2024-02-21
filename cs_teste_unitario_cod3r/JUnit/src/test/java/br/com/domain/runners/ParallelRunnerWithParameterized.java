package br.com.domain.runners;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.runners.Parameterized;
import org.junit.runners.model.RunnerScheduler;

/**
 * Este método ajuda nos testes, de forma que, ao terminar a execução de um
 * método, outro já se inicia, se acordo com a quantidade de taregas paralelas
 * definidas pela thread.
 * 
 * Cada classe desse tipo, contém um extends das classes que iráo rodar pelo
 * ParallelRunner, se assim, forém do mesmo tipo desse extends
 */
public class ParallelRunnerWithParameterized extends Parameterized {

	public ParallelRunnerWithParameterized(Class<?> testClass) throws Throwable {
		super(testClass);

		setScheduler(new ThreadPoll());
	}

	private static class ThreadPoll implements RunnerScheduler {
		private ExecutorService executor;

		public ThreadPoll() {
			executor = Executors.newFixedThreadPool(2);
		}

		@Override
		public void schedule(Runnable run) {
			executor.submit(run);
		}

		@Override
		public void finished() {
			executor.shutdown();

			try {
				executor.awaitTermination(10, TimeUnit.MINUTES);
			} catch (InterruptedException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}

	}

}
