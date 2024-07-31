import com.chen.ChenApplication;
import com.chen.common.utils.json.FastJsonUtils;
import com.chen.domain.article_category.ArticleCategoryBO;
import com.chen.service.article_category.ArticleCategoryService;
import com.chen.service.article_category.impl.ArticleCategoryServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Author chenyunzhi
 * @DATE 2024/7/31 11:26
 * @Description:
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ChenApplication.class)
public class CategoryTest {

    @Autowired
    private ArticleCategoryService articleCategoryService;
    @Test
    public void ArticleCategoryServiceImplTest() {
        List<ArticleCategoryBO> allCategories = articleCategoryService.getAllCategories();
        System.out.println(FastJsonUtils.toJson(allCategories));
    }
}
