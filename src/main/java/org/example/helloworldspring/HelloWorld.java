package org.example.helloworldspring;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/HelloWorld")
public class HelloWorld {

    private List<Message> messages = new ArrayList<>();

    @GetMapping("/messages")
    public List<Message> getAllMessages() {
        return messages;
    }

    @GetMapping("/{name}")
    public String sayHello(@PathVariable String name) {
        return "Hello, " + name;
    }

    @PostMapping("/messages")
    public String addMessage(@RequestBody Message message) {
        messages.add(message);
        return "Message added " + message.toString();
    }

    @DeleteMapping("/messages/{id}")
    public String deleteMessage(@PathVariable String id) {
        boolean removed = messages.removeIf(message -> message.getId().equals(id));
        if (removed) {
            return "Message with id " + id + " has been deleted.";
        } else {
            return "Message with id " + id + " not found.";
        }
    }


}
