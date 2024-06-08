package com.ftn.sbnz.model.events;

import com.ftn.sbnz.model.models.Rating;
import com.ftn.sbnz.model.models.Song;
import com.ftn.sbnz.model.models.User;
import lombok.*;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Role(Role.Type.EVENT)
@Timestamp("executionTime")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date executionTime;

    @Enumerated(EnumType.STRING)
    private EventType eventType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "song_id")
    private Song song;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rating_id")
    private Rating rating;

}
