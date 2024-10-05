package test.springboot.nvdung.seeder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import test.springboot.nvdung.model.Enum.ProductGender;
import test.springboot.nvdung.model.*;
import test.springboot.nvdung.repository.*;

@Component()
@Order(2)
public class ProductSeed implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Autowired
    private ProductImageRepository productImageRepository;

    private static final String[] ADJECTIVES = {
            "Mới", "Sang trọng", "Thời trang", "Năng động", "Phong cách", "Thoải mái"
    };

    private static final String[] NOUNS = {
            "Áo sơ mi", "Quần jeans", "Váy", "Áo khoác", "Áo thun", "Quần short"
    };

    private static String generateRandomProductName() {
        Random random = new Random();
        String adjective = ADJECTIVES[random.nextInt(ADJECTIVES.length)];
        String noun = NOUNS[random.nextInt(NOUNS.length)];
        return adjective + " " + noun;
    }

    private static int getRandomPrice() {
        Random random = new Random();
        return random.nextInt((100000 - 50000) + 1) + 50000;
    }

    private static int getRandomDiscount() {
        Random random = new Random();
        return random.nextInt(101);
    }

    private static ProductGender getRandomGender() {
        ProductGender[] genders = ProductGender.values();
        Random random = new Random();
        int randomIndex = random.nextInt(genders.length);
        return genders[randomIndex];
    }

    private static Integer getRandomQuanity() {
        Random random = new Random();
        return random.nextInt(29);
    }

    private static LocalDate getRandomDiscountTo() {
        Random random = new Random();
        LocalDate today = LocalDate.now();
        int daysToAdd = random.nextInt(365);
        return today.plusDays(daysToAdd);
    }

    private void createProductImage(Integer productId) {
        List<String> imageURLs = new ArrayList<>();
        imageURLs.add("https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/3_pva2f1.jpg");
        imageURLs.add("https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/5_lhahp6.jpg");
        imageURLs.add("https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/1_rg9qi2.jpg");
        imageURLs.add("https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/2_gw1gt9.jpg");
        imageURLs.add("https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/4_vwro7d.jpg");

        imageURLs.stream().forEach((image) -> {
            productImageRepository.save(ProductImage.builder()
                    .url(image)
                    .product(Product.builder()
                            .id(productId)
                            .build())
                    .build());
        });
    }

    private void createProductDetail(Integer productId) {
        List<Integer> colorIds = Arrays.asList(11, 12, 13, 14);
        List<Integer> sizeIds = Arrays.asList(15, 16, 17, 18, 19);

        colorIds.stream().forEach((colorId) -> {
            sizeIds.stream().forEach((sizeId) -> {
                productDetailRepository.save(ProductDetail.builder()
                        .product(Product.builder()
                                .id(productId)
                                .build())
                        .quantity(getRandomQuanity())
                        .color(Constant.builder()
                                .id(colorId)
                                .build())
                        .size(Constant.builder()
                                .id(sizeId)
                                .build())
                        .build());
            });
        });
    }

    private void createProduct() {
        List<Integer> categoryIds = Arrays.asList(1, 2, 3, 4);
        List<Integer> styleIds = Arrays.asList(5, 6, 7, 8, 9, 10);

        categoryIds.stream().forEach((categoryId) -> {
            styleIds.stream().forEach((styleId) -> {
                Product newProduct = productRepository.save(Product.builder()
                        .price(getRandomPrice())
                        .discount(getRandomDiscount())
                        .name(generateRandomProductName())
                        .gender(getRandomGender())
                        .description(
                                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. ")
                        .discountTo(getRandomDiscountTo())
                        .category(Constant.builder().id(categoryId).build())
                        .style(Constant.builder().id(styleId).build())
                        .build());

                createProductImage(newProduct.getId());
                createProductDetail(newProduct.getId());
            });
        });
    }

    @Override
    public void run(String... args) throws Exception {
        if (productRepository.count() == 0) {
            this.createProduct();
        }
    }
}
