--product , subcategory, topcategory 조인

select t.topcategory_id , s.subcategory_id , s.sub_name ,p.product_id, p.product_name ,p.brand ,p.price ,p.info,p.product_img 
from topcategory t ,subcategory s , product p 
where t.topcategory_id = s.topcategory_id 
and s.subcategory_id = p.subcategory_id
and product_id = 5;