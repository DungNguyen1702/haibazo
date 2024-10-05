package test.springboot.nvdung.seeder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import test.springboot.nvdung.model.Constant;
import test.springboot.nvdung.model.Enum.ConstantTypeEnum;
import test.springboot.nvdung.repository.ConstantRepository;

@Component()
@Order(1)
public class ConstantSeed implements CommandLineRunner {

    @Autowired
    private ConstantRepository constantRepository;

    @Override
    public void run(String... args) throws Exception {
        if (constantRepository.count() == 0) {
            // category
            List<Constant> categories = new ArrayList<>();
            categories.add(Constant.builder()
                    .type(ConstantTypeEnum.CATEGORY)
                    .value("Home & Decor")
                    .build());
            categories.add(Constant.builder()
                    .type(ConstantTypeEnum.CATEGORY)
                    .value("Cloting")
                    .build());
            categories.add(Constant.builder()
                    .type(ConstantTypeEnum.CATEGORY)
                    .value("Accessories")
                    .build());
            categories.add(Constant.builder()
                    .type(ConstantTypeEnum.CATEGORY)
                    .value("Outdoor")
                    .build());

            categories.stream().forEach((category) -> {
                constantRepository.save(category);
            });

            // style
            List<Constant> styles = new ArrayList<>();
            styles.add(Constant.builder()
                    .type(ConstantTypeEnum.STYLE)
                    .value("Morden")
                    .build());
            styles.add(Constant.builder()
                    .type(ConstantTypeEnum.STYLE)
                    .value("Sweetwear")
                    .build());
            styles.add(Constant.builder()
                    .type(ConstantTypeEnum.STYLE)
                    .value("ColorFull")
                    .build());
            styles.add(Constant.builder()
                    .type(ConstantTypeEnum.STYLE)
                    .value("Patchwork")
                    .build());
            styles.add(Constant.builder()
                    .type(ConstantTypeEnum.STYLE)
                    .value("Bohemiam")
                    .build());
            styles.add(Constant.builder()
                    .type(ConstantTypeEnum.STYLE)
                    .value("Vintage")
                    .build());

            styles.stream().forEach((category) -> {
                constantRepository.save(category);
            });

            // color
            List<Constant> colors = new ArrayList<>();
            colors.add(Constant.builder()
                    .type(ConstantTypeEnum.COLOR)
                    .value("#21c89a")
                    .build());
            colors.add(Constant.builder()
                    .type(ConstantTypeEnum.COLOR)
                    .value("#ae83f7")
                    .build());
            colors.add(Constant.builder()
                    .type(ConstantTypeEnum.COLOR)
                    .value("#e05564")
                    .build());
            colors.add(Constant.builder()
                    .type(ConstantTypeEnum.COLOR)
                    .value("#121212")
                    .build());

            colors.stream().forEach((category) -> {
                constantRepository.save(category);
            });

            // size
            List<Constant> sizes = new ArrayList<>();
            sizes.add(Constant.builder()
                    .type(ConstantTypeEnum.SIZE)
                    .value("S")
                    .build());
            sizes.add(Constant.builder()
                    .type(ConstantTypeEnum.SIZE)
                    .value("M")
                    .build());
            sizes.add(Constant.builder()
                    .type(ConstantTypeEnum.SIZE)
                    .value("L")
                    .build());
            sizes.add(Constant.builder()
                    .type(ConstantTypeEnum.SIZE)
                    .value("XL")
                    .build());
            sizes.add(Constant.builder()
                    .type(ConstantTypeEnum.SIZE)
                    .value("2XL")
                    .build());

            sizes.stream().forEach((category) -> {
                constantRepository.save(category);
            });
        }
    }
}
