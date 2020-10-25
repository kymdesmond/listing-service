package com.cars.listingservice.aggregate;

import com.cars.listingservice.command.CreateUserCommand;
import com.cars.listingservice.event.UserCreatedEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Aggregate
public class UserAggregate {

    @AggregateIdentifier
    private UUID id;
    private String name;
    private String email;
    private String password;

    @CommandHandler
    public UserAggregate(CreateUserCommand command) {
        AggregateLifecycle.apply(
                new UserCreatedEvent(command.getId(), command.getName(), command.getEmail(), command.getPassword())
        );
    }

    @EventSourcingHandler
    public void on(UserCreatedEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.email = event.getEmail();
        this.password = event.getPassword();
    }

    //TODO: Update User Event, Command
}
