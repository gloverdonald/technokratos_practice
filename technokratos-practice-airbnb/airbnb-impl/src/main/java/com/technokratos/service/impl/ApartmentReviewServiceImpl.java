package com.technokratos.service.impl;

import com.technokratos.dto.request.ApartmentReviewRequest;
import com.technokratos.dto.response.ApartmentReviewResponse;
import com.technokratos.exception.AccessDeniedException;
import com.technokratos.exception.ApartmentNotFoundException;
import com.technokratos.exception.ApartmentReviewNotFoundException;
import com.technokratos.exception.UserNotFoundException;
import com.technokratos.mapper.ApartmentReviewMapper;
import com.technokratos.model.ApartmentEntity;
import com.technokratos.model.ApartmentReviewEntity;
import com.technokratos.model.UserEntity;
import com.technokratos.repository.ApartmentRepository;
import com.technokratos.repository.ApartmentReviewRepository;
import com.technokratos.repository.UserRepository;
import com.technokratos.service.ApartmentReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ApartmentReviewServiceImpl implements ApartmentReviewService {
    private final UserRepository userRepository;
    private final ApartmentReviewRepository apartmentReviewRepository;
    private final ApartmentReviewMapper apartmentReviewMapper;
    private final ApartmentRepository apartmentRepository;

    @Override
    public ApartmentReviewResponse create(UUID apartmentId, ApartmentReviewRequest reviewRequest, UserDetails userDetails) {
        ApartmentEntity apartment = apartmentRepository.findById(apartmentId).orElseThrow(ApartmentNotFoundException::new);
        UserEntity user = userRepository.findByEmail(userDetails.getUsername()).orElseThrow(UserNotFoundException::new);
        ApartmentReviewEntity apartmentReview = apartmentReviewMapper.toEntity(reviewRequest);
        apartmentReview.setApartment(apartment);
        apartmentReview.setAuthor(user);
        return apartmentReviewMapper.toResponse(apartmentReviewRepository.save(apartmentReview));
    }

    @Override
    public List<ApartmentReviewResponse> getReviewByApartment(UUID apartmentId) {
        return apartmentReviewRepository
                .findByApartment_Id(apartmentId)
                .stream().map(apartmentReviewMapper::toResponse)
                .toList();
    }

    @Override
    public ApartmentReviewResponse updateReviewByApartment(UUID reviewId, ApartmentReviewRequest reviewRequest, UserDetails userDetails) {
        UserEntity user = userRepository.findByEmail(userDetails.getUsername()).orElseThrow(UserNotFoundException::new);
        ApartmentReviewEntity apartmentReview = apartmentReviewRepository.findById(reviewId).orElseThrow(ApartmentReviewNotFoundException::new);
        if (!user.getId().equals(apartmentReview.getAuthor().getId())) {
            throw new AccessDeniedException();
        }
        apartmentReviewMapper.update(apartmentReview, reviewRequest);
        return apartmentReviewMapper.toResponse(apartmentReviewRepository.save(apartmentReview));
    }
}
