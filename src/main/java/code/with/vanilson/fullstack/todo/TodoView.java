package code.with.vanilson.fullstack.todo;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

/**
 * TodoView
 *
 * @author vamuhong
 * @version 1.0
 * @since 2024-09-08
 */

@Route("/todos")
@SuppressWarnings("unused")
public class TodoView extends VerticalLayout {

    private final TodoRepo todoRepo;

    public TodoView(TodoRepo todoRepo) {
        this.todoRepo = todoRepo;
        var task = new TextField();
        var button = new Button("Add");
        var todos = new VerticalLayout();

        todos.setPadding(false);
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        button.addClickShortcut(Key.ENTER);

        button.addClickListener(e -> {
            var todo = todoRepo.save(new Todo(task.getValue()));
            todos.add(createCheckBox(todo));
            task.clear();
        });

        todoRepo.findAll()
                .forEach(todo -> todos.add(createCheckBox(todo)));

        add(
                new H1("Todo"),
                new HorizontalLayout(task, button),
                todos

        );
    }

    private Component createCheckBox(Todo todo) {
        return new Checkbox(todo.getTask(), todo.isDone(), e -> {
            todo.setDone(e.getValue());
            todoRepo.save(todo);
        });
    }
}