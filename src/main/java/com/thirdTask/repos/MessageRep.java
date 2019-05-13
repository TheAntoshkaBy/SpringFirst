package com.thirdTask.repos;

import com.thirdTask.domain.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRep  extends CrudRepository<Message, Long> {
}
