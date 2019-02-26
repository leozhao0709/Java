package com.lzhao.jpa.entity;

import com.lzhao.jpa.repository.CategoryRepository;
import com.lzhao.jpa.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ItemAndCategoryTest {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void manyToManyInsert() {
        Category category1 = new Category("C-AA-1");
        Category category2 = new Category("C-AA-2");

        Item item1 = new Item("I-AA-1");
        Item item2 = new Item("I-AA-2");

        category1.getItems().add(item1);
        category1.getItems().add(item2);
        category2.getItems().add(item1);
        category2.getItems().add(item2);

        item1.getCategories().add(category1);
        item1.getCategories().add(category2);
        item2.getCategories().add(category1);
        item2.getCategories().add(category2);

        categoryRepository.save(category1);
        categoryRepository.save(category2);
        itemRepository.save(item1);
        itemRepository.save(item2);
    }
}
