////http://dunro.com/api/v1.3/business/show/584622aa8efaa
////select *
////        from advers s pivot(max(value) for key in('lng',
////        'slugged_title',
////        'rates',
////        'uuid',
////        'guilds',
////        'status',
////        'has_active_contract',
////        'id',
////        'title',
////        'slogan',
////        'logo',
////        'knots',
////        'tel_1',
////        'description',
////        'lat',
////        'address'
////
//
//
//ALTER TABLE `advers`  CHANGE COLUMN `slugged_title` `slugged_title` TEXT NULL DEFAULT NULL ;
//ALTER TABLE `advers`  CHANGE COLUMN `slugged_title` `slugged_title` TEXT NULL DEFAULT NULL ;
//ALTER TABLE `advers`  CHANGE COLUMN `uuid` `uuid` TEXT NULL DEFAULT NULL ;
//ALTER TABLE `advers`  CHANGE COLUMN `guilds` `guilds` TEXT NULL DEFAULT NULL ;
//ALTER TABLE `advers`  CHANGE COLUMN `title` `title` TEXT NULL DEFAULT NULL ;
//ALTER TABLE `advers`  CHANGE COLUMN `slogan` `slogan` TEXT NULL DEFAULT NULL ;
//ALTER TABLE `advers`  CHANGE COLUMN `logo` `logo` TEXT NULL DEFAULT NULL ;
//
//
//
//
//
//
//
//
