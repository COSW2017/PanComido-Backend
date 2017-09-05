package edu.eci.cosw.pancomido.controller;

import edu.eci.cosw.pancomido.model.Todo;
import edu.eci.cosw.pancomido.service.TodoService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.List;

/**
 * @author Santiago Carrillo
 * 8/21/17.
 */
@RestController
@RequestMapping( "api" )
public class TodoController
{

    @Autowired
    private TodoService todoService;

    @RequestMapping( value = "/todo", method = RequestMethod.POST )
    public Todo addTodo( @RequestBody Todo todo )
            throws ServletException
    {
        return todoService.addTodo(todo);

    }

    @RequestMapping( value = "/todo", method = RequestMethod.GET )
    public List<Todo> getTodo()
            throws ServletException
    {
        return todoService.getTodoList();
    }


}
