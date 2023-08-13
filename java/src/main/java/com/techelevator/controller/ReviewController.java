package com.techelevator.controller;

import com.techelevator.dao.ReviewDao;
import com.techelevator.model.Review;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewDao reviewDao;
    public ReviewController(ReviewDao reviewDao){
        this.reviewDao = reviewDao;
    }

    //works and displays username
    @GetMapping("/all")
    public List<Review> viewReviews() {
        List review = reviewDao.getAllReviews();
        if (review != null) {

        }else {
            System.out.println("No Reviews Found");
        }
        return review;
    }

    //works and displays username
    @ResponseStatus
    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable int id) {
        Review review = reviewDao.getReviewById(id);
        if (review != null) {

        } else {
            System.out.println("No Review Found For Selected ID");
        }
        return review;
    }

    //works - need to add principal so you can only review on your own name
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public Review createReview(@Valid @RequestBody Review review, Principal principal) {
        return reviewDao.createReview(review, principal);
    }

}
