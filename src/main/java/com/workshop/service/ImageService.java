package com.workshop.service;

import com.workshop.db.entity.Image;
import com.workshop.db.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final PersonalBicycleService customerRepository;
    private final ImageRepository imageRepository;

    @Transactional
    public byte[] findById(Long id) {


        return imageRepository.findById(id).map(Image::getImageData).orElseGet(() -> new byte[0]);
    }

    @Transactional
    @SneakyThrows
    public void saveImageFile(MultipartFile file) {

        Image image = new Image();
        image.setImageData(file.getBytes());

        imageRepository.save(image);
    }

}
