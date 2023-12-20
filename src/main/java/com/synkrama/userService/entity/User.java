package com.synkrama.userService.entity;

import com.synkrama.userService.entity.eenum.UserStatus;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SQLDelete(sql = "update user set user_is_active = false where user_id = ?") //soft delete
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_contact", unique = true)
    private String userContact;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_image_url", length = 5000)
    private String userImageUrl;

    @Column(name = "user_role")
    private Long userRole;

    @Column(name = "user_status")
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    @Column(name = "user_is_active")
    private Boolean userIsActive = Boolean.TRUE;

    @Column(name = "user_pending_notification_count")
    private Long userPendingNotificationCount;

    @Column(name = "user_all_time_notification_count")
    private Long userAllTimeNotificationCount;

    @CreationTimestamp
    @Column(name = "user_created_date_time", nullable = false, updatable = false)
    private Date userCreatedDateTime = new Date();

    @UpdateTimestamp
    @Column(name = "user_updated_date_time")
    private Date userUpdatedDateTime = new Date();
}
