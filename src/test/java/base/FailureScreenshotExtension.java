package base;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Supplier;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

final class FailureScreenshotExtension implements AfterTestExecutionCallback {
    private final Supplier<WebDriver> driverSupplier;
    FailureScreenshotExtension(Supplier<WebDriver> driverSupplier) { this.driverSupplier = driverSupplier; }

    @Override
    public void afterTestExecution(ExtensionContext context) throws IOException {
        if (context.getExecutionException().isEmpty()) return;
        WebDriver driver = driverSupplier.get();
        if (!(driver instanceof TakesScreenshot screenshotDriver)) return;
        Path directory = Path.of("target", "screenshots");
        Files.createDirectories(directory);
        String safeName = context.getDisplayName().replaceAll("[^a-zA-Z0-9._-]+", "_");
        Files.write(directory.resolve(safeName + ".png"), screenshotDriver.getScreenshotAs(OutputType.BYTES));
    }
}
