package integration;

import org.codehaus.jackson.JsonNode;
import org.junit.Test;
import services.DefaultGitRestAPIWrapper;

import static org.fest.assertions.Assertions.assertThat;

import static play.test.Helpers.*;

public class DefaultGitRestAPIWrapperTest {
    @Test
    public void getJsonAsText() {
        running(fakeApplication(), new Runnable(){
            public void run(){
                DefaultGitRestAPIWrapper wrapper = new DefaultGitRestAPIWrapper();
                JsonNode json = wrapper.getGithubWatchersJson("KonstantinG", "todolist-kata");
                assertThat(json.get(0).get("login").toString()).contains("\"KonstantinG\"");
                assertThat(json.get(1).get("login").toString()).contains("\"semenodm\"");
            }
        });
    }
}
