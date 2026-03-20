package runner;

import service.BlazeDemoService;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.concurrent.*;

public class RunnerTest {

    public static void main(String[] args) throws Exception {

        int totalRequests = 250;
        int threads = 50;
        String csvFile = "performance.csv";

        ExecutorService executor = Executors.newFixedThreadPool(threads);

        PrintWriter writer = new PrintWriter(new FileWriter(csvFile));
        writer.println("thread,startTime,endTime,duration_ms,status");

        for (int i = 0; i < totalRequests; i++) {
            final int threadNum = i + 1;

            executor.submit(() -> {
                BlazeDemoService service = new BlazeDemoService();

                long start = System.currentTimeMillis();
                String status = "SUCCESS";

                try {
                    service.getHomePage();
                    service.findFlight("Paris", "London");
                    service.chooseFlight("123", "200", "TestAir", "Paris", "London");
                    service.purchaseTicket("Teste", "Rua Teste", "SP", "SP", "00000",
                            "visa", "4111111111111111", "12", "2026", "Teste");

                } catch (Exception e) {
                    status = "FAIL";
                    e.printStackTrace();
                }

                long end = System.currentTimeMillis();
                long duration = end - start;

                synchronized (writer) {
                    writer.println(threadNum + "," + start + "," + end + "," + duration + "," + status);
                    writer.flush();
                }

                System.out.println("thread " + threadNum + " finalizada: " + duration + "ms");
            });
        }

        executor.shutdown();
        executor.awaitTermination(15, TimeUnit.MINUTES);

        writer.close();

        System.out.println("CSV gerado!");
    }
}