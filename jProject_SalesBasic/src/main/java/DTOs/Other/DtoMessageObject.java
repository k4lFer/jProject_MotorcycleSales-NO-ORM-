package DTOs.Other;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kalfe
 */
public class DtoMessageObject {
    private List<String> listMessage;
    private String type;

    public DtoMessageObject() {
        listMessage = new ArrayList<>();
        type = "error";
    }

    public boolean existsMessage() {
        return !listMessage.isEmpty();
    }

    public void addMessage(String message) {
        listMessage.add(message);
    }

    public void success() {
        type = "success";
    }

    public void error() {
        type = "error";
    }

    public void warning() {
        type = "warning";
    }

    public void exception() {
        type = "exception";
    }

    // Getters y setters

    public List<String> getListMessage() {
        return listMessage;
    }

    public void setListMessage(List<String> listMessage) {
        this.listMessage = listMessage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
