create or replace view parts_view as
select id, product_id, product, brand, model, series, purpose, weight, is_official, ean, manufacturers_code, year, comment
from fork
union all
select id, product_id, product, brand, model, series, purpose, weight, is_official, ean, manufacturers_code, year, comment
from handlebar
union all
select id, product_id, product, brand, model, series, purpose, weight, is_official, ean, manufacturers_code, year, comment
from chain
union all
select id, product_id, product, brand, model, series, purpose, weight, is_official, ean, manufacturers_code, year, comment
from disc
union all
select id, product_id, product, brand, model, series, purpose, weight, is_official, ean, manufacturers_code, year, comment
from chainring
union all
select id, product_id, product, brand, model, series, purpose, weight, is_official, ean, manufacturers_code, year, comment
from bottom_bracket
union all
select id, product_id, product, brand, model, series, purpose, weight, is_official, ean, manufacturers_code, year, comment
from rear_derailleur
union all
select id, product_id, product, brand, model, series, purpose, weight, is_official, ean, manufacturers_code, year, comment
from shifter
union all
select id, product_id, product, brand, model, series, purpose, weight, is_official, ean, manufacturers_code, year, comment
from grips
union all
select id, product_id, product, brand, model, series, purpose, weight, is_official, ean, manufacturers_code, year, comment
from bicycle_part
union all
select id, product_id, product, brand, model, series, purpose, weight, is_official, ean, manufacturers_code, year, comment
from wheel
union all
select id, product_id, product, brand, model, series, purpose, weight, is_official, ean, manufacturers_code, year, comment
from hub
union all
select id, product_id, product, brand, model, series, purpose, weight, is_official, ean, manufacturers_code, year, comment
from front_derailleur
union all
select id, product_id, product, brand, model, series, purpose, weight, is_official, ean, manufacturers_code, year, comment
from seatpost
union all
select id, product_id, product, brand, model, series, purpose, weight, is_official, ean, manufacturers_code, year, comment
from head_set
union all
select id, product_id, product, brand, model, series, purpose, weight, is_official, ean, manufacturers_code, year, comment
from cassette
union all
select id, product_id, product, brand, model, series, purpose, weight, is_official, ean, manufacturers_code, year, comment
from frame
union all
select id, product_id, product, brand, model, series, purpose, weight, is_official, ean, manufacturers_code, year, comment
from stem
union all
select id, product_id, product, brand, model, series, purpose, weight, is_official, ean, manufacturers_code, year, comment
from damper
union all
select id, product_id, product, brand, model, series, purpose, weight, is_official, ean, manufacturers_code, year, comment
from pedals
union all
select id, product_id, product, brand, model, series, purpose, weight, is_official, ean, manufacturers_code, year, comment
from saddle
union all
select id, product_id, product, brand, model, series, purpose, weight, is_official, ean, manufacturers_code, year, comment
from seatpost_clamp
union all
select id, product_id, product, brand, model, series, purpose, weight, is_official, ean, manufacturers_code, year, comment
from rim
union all
select id, product_id, product, brand, model, series, purpose, weight, is_official, ean, manufacturers_code, year, comment
from brake_hydraulic
union all
select id, product_id, product, brand, model, series, purpose, weight, is_official, ean, manufacturers_code, year, comment
from brake_caliper
union all
select id, product_id, product, brand, model, series, purpose, weight, is_official, ean, manufacturers_code, year, comment
from brake_lever
union all
select id, product_id, product, brand, model, series, purpose, weight, is_official, ean, manufacturers_code, year, comment
from tyre
union all
select id, product_id, product, brand, model, series, purpose, weight, is_official, ean, manufacturers_code, year, comment
from crank;