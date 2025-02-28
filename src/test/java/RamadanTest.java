import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RamadanTest {
    public static void main(String[] args) {
        String filePath = System.getProperty("user.dir") + "/ramadan_greeting.html";

        String htmlContent = """
        <!DOC TYPE html>
        <html lang="ar">
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>رمضان مبارك</title>
            <style>
                @import url('https://fonts.googleapis.com/css2?family=Amiri:wght@700&display=swap');

                body {
                    background: linear-gradient(to right, #0F2027, #203A43, #2C5364);
                    display: flex;
                    justify-content: center;
                    align-items: center;
                    height: 100vh;
                    margin: 0;
                    font-family: 'Amiri', serif;
                    text-align: center;
                    color: white;
                    flex-direction: column;
                }

                .message-box {
                    background: rgba(255, 255, 255, 0.1);
                    padding: 25px;
                    border-radius: 15px;
                    box-shadow: 0px 4px 20px rgba(255, 215, 0, 0.5);
                    animation: fadeIn 1.5s ease-in-out;
                }

                h1 {
                    font-size: 55px;
                    margin: 0;
                    color: gold;
                    text-shadow: 4px 4px 15px rgba(255, 215, 0, 0.7);
                }

                p {
                    font-size: 24px;
                    margin-top: 10px;
                    color: white;
                    opacity: 0.9;
                }

                .crescent-moon {
                    font-size: 80px;
                    color: gold;
                    animation: swing 2s infinite alternate;
                }

                .author {
                    font-size: 22px;
                    color: gold;
                    margin-top: 15px;
                    text-shadow: 2px 2px 10px rgba(255, 215, 0, 0.7);
                    font-style: italic;
                }

                @keyframes fadeIn {
                    from { opacity: 0; transform: scale(0.8); }
                    to { opacity: 1; transform: scale(1); }
                }

                @keyframes swing {
                    from { transform: rotate(-10deg); }
                    to { transform: rotate(10deg); }
                }
            </style>
        </head>
        <body>
            <div class="message-box">
                <div class="crescent-moon">🌙</div>
                <h1>رمضان مبارك</h1>
                <p>تقبل الله منا ومنكم صالح الأعمال</p>
                <p class="author">Marouen Kahia :مع تحياتي </p>
            </div>
        </body>
        </html>
        """;

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(htmlContent);
        } catch (IOException e) {
            System.out.println("خطأ أثناء إنشاء ملف HTML: " + e.getMessage());
            return;
        }

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        File file = new File(filePath);
        driver.get("file:///" + file.getAbsolutePath());

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
