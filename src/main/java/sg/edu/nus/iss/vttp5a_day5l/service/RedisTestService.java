package sg.edu.nus.iss.vttp5a_day5l.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.vttp5a_day5l.repo.ListRepo;
import sg.edu.nus.iss.vttp5a_day5l.repo.ValueRepo;

@Service
public class RedisTestService {

    @Autowired
    ListRepo lRepo;

    @Autowired
    ValueRepo vRepo;

     // Write service functions that perform some operation to the repo?
}