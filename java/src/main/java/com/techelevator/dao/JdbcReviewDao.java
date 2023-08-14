package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Review;
import com.techelevator.model.ReviewResponse;
import com.techelevator.model.User;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcReviewDao implements ReviewDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcReviewDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Review> getAllReviews() {
        List<Review> listOfReviews = new ArrayList<>();
        String sql = "SELECT review_id, reviewer, office_name, username, review_rating, review_title, review_content, review_date " +
                "FROM review " +
                "JOIN users ON review.reviewer = users.user_id " +
                "JOIN office ON review.reviewed_office = office.office_id;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Review review = mapRowToReview(results);
                listOfReviews.add(review);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
            return listOfReviews;

    }

    @Override
    public Review getReviewById(int id) {
        Review review = null;
        String sql = "SELECT review_id, reviewer, office_name, username, review_rating, review_title, review_content, review_date FROM review " +
                "JOIN users ON review.reviewer = users.user_id " +
                "JOIN office ON review.reviewed_office = office.office_id " +
                "WHERE review_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            if (results.next()) {
                review = mapRowToReview(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return review;

    }

    @Override
    public Review createReview(Review review, Principal principal) {
        Review newReview = null;
        String sql = "INSERT INTO review (reviewer, reviewed_office, review_rating, " +
                "review_title, review_content, review_date) values ('?', '?', '?', '?', '?', '?') RETURNING review_id;";

        try {
            int newReviewId = jdbcTemplate.queryForObject(sql, int.class, review.getReviewer(), review.getReviewedOffice(), review.getReviewRating(), review.getReviewTitle(), review.getReviewContent(), review.getReviewDate());
            newReview = getReviewById(newReviewId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return newReview;
    }

    @Override
    public Review updateReview(Review review) {
        Review updatedReview = null;
        String sql = "UPDATE review SET review_rating = ?, review_content = ? WHERE review_id = ?";
        try {
            jdbcTemplate.update(sql, review.getReviewRating(), review.getReviewContent());
            updatedReview = getReviewById(review.getReviewId());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return updatedReview;
    }

    @Override
    public Review reviewResponse(ReviewResponse reviewResponse) {
        Review newReviewResponse = null;
        String sql = "INSERT INTO review_response (review_id, responder, response_content) values (?, ?, ?) RETURNING response_id";

        try {
            int newReviewResponseId = jdbcTemplate.queryForObject(sql, int.class, reviewResponse.getReviewId(), reviewResponse.getResponder(), reviewResponse.getResponseContent());
            newReviewResponse = getReviewById(newReviewResponseId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return newReviewResponse;
    }

    private Review mapRowToReview(SqlRowSet rs) {
        Review review = new Review();
        review.setReviewId(rs.getInt("review_id"));
        review.setReviewer(rs.getInt("reviewer"));
        review.setOfficeName(rs.getString("office_name"));
        review.setUsername(rs.getString("username"));
        review.setReviewRating(rs.getInt("review_rating"));
        review.setReviewTitle(rs.getString("review_title"));
        review.setReviewContent(rs.getString("review_content"));
        review.setReviewDate(rs.getDate("review_date"));

        return review;
    }
}
