package systems;

import static org.junit.Assert.assertEquals;

import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.events.SNSEvent;
import org.junit.Test;
import systems.Macd1;

import java.util.Arrays;

public class Macd1Test {

    @Test
    public void Macd1Handler() {

        SNSEvent.SNS snsMessage = new SNSEvent.SNS();
        snsMessage.setMessage("{\"Open\":685.38,\"Close\":691,\"High\":691,\"Low\":683.62,\"Volume\":1182.64109483,\"LastOriginID\":18936678,\"TickEndTime\":1465806239}");

        SNSEvent.SNSRecord record = new SNSEvent.SNSRecord();
        record.setSns(snsMessage);

        SNSEvent event = new SNSEvent();
        event.setRecords(Arrays.asList(record));

        Context context = new Context() {
            public String getAwsRequestId() {
                return "AwsRequestId";
            }

            public String getLogGroupName() {
                return "LogGroupName";
            }

            public String getLogStreamName() {
                return "LogStreamName";
            }

            public String getFunctionName() {
                return "FunctionName";
            }

            public String getFunctionVersion() {
                return "FunctionVersion";
            }

            public String getInvokedFunctionArn() {
                return "InvokedFunctionArn";
            }

            public CognitoIdentity getIdentity() {
                return null;
            }

            public ClientContext getClientContext() {
                return null;
            }

            public int getRemainingTimeInMillis() {
                return 0;
            }

            public int getMemoryLimitInMB() {
                return 0;
            }

            public LambdaLogger getLogger() {
                return null;
            }
        };

        Macd1 handler = new Macd1();

        handler.handler(event, context);
    }
}