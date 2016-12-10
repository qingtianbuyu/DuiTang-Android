package com.duitang.entity;

import java.util.List;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/10 上午9:58
 */
public class ContentGroup {

    /**
     * group_id : index_hot_banner
     * content_type : banner
     * group_name : 流行趋势
     * group_items : [{"icon_url":"http://img4q.duitang.com/uploads/people/201610/12/20161012174211_u8HBs.jpeg","name":"今日TOP榜","target":"duitang://www.duitang.com/theme/detail/?theme_id=554c8abaa310def67913c5c0&theme_alias=%E4%BB%8A%E6%97%A5TOP%E6%A6%9C&app_layout=BLOG_THEME"},{"icon_url":"http://img3.duitang.com/uploads/item/201605/04/20160504220949_PyeFm.jpeg","name":"宅家生活","target":"duitang://www.duitang.com/theme/detail/?theme_id=56e0e55e631ed3094645091c&theme_alias=%E5%AE%85%E5%AE%B6%E7%94%9F%E6%B4%BB&app_layout=HEAP_THEME"},{"icon_url":"http://img4q.duitang.com/uploads/item/201610/12/20161012180518_35Sxu.jpeg","name":"光影世界","target":"duitang://www.duitang.com/theme/detail/?theme_id=56c56da2631ed34dd29c1c24&theme_alias=%E5%85%89%E5%BD%B1%E4%B8%96%E7%95%8C&app_layout=BLOG_THEME"},{"icon_url":"http://img4q.duitang.com/uploads/people/201605/11/20160511185629_kyH8n.jpeg","name":"旅拍文化","target":"duitang://www.duitang.com/theme/detail/?theme_id=56c5495cd7c673313e8bff72&theme_alias=%E6%97%85%E6%8B%8D%E6%96%87%E5%8C%96&app_layout=HEAP_THEME"},{"icon_url":"http://img4q.duitang.com/uploads/people/201610/12/20161012173740_EJTaK.jpeg","name":"赏味期限","target":"duitang://www.duitang.com/theme/detail/?theme_id=56c53beca349937c0e214f47&theme_alias=%E8%B5%8F%E5%91%B3%E6%9C%9F%E9%99%90&app_layout=HEAP_THEME"},{"icon_url":"http://img4q.duitang.com/uploads/people/201610/12/20161012174026_eVSMd.jpeg","name":"手艺宅子","target":"duitang://www.duitang.com/theme/detail/?theme_id=56c56ee87632ab11f4393acb&theme_alias=%E6%89%8B%E8%89%BA%E5%AE%85%E5%AD%90&app_layout=HEAP_THEME"},{"icon_url":"http://img4q.duitang.com/uploads/people/201603/30/20160330140618_cFdf4.jpeg","name":"种草清单","target":"duitang://www.duitang.com/theme/detail/?theme_id=56c566c884bccb92faff3eee&theme_alias=%E7%A7%8D%E8%8D%89%E6%B8%85%E5%8D%95&app_layout=HEAP_THEME"}]
     */

    private String group_id;
    private String content_type;
    private String group_name;
    private List<ContentGroupItem> group_items;

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getContent_type() {
        return content_type;
    }

    public void setContent_type(String content_type) {
        this.content_type = content_type;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public List<ContentGroupItem> getGroup_items() {
        return group_items;
    }

    public void setGroup_items(List<ContentGroupItem> group_items) {
        this.group_items = group_items;
    }

}
