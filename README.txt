Model
รับผิดชอบด้านข้อมูลและ Business Logic ทั้งหมดของระบบ
ไฟล์หลัก:
Citizen.java
เก็บข้อมูลประชาชน เช่น อายุ ประเภท สภาวะสุขภาพ และสถานะการได้รับที่พัก

Shelter.java
แทนศูนย์พักพิง เก็บความจุ ระดับความเสี่ยง และจำนวนผู้เข้าพักปัจจุบัน

Assignment.java
เก็บข้อมูลการจับคู่ระหว่างประชาชนกับศูนย์พักพิง

ShelterService.java
เป็น Service Layer ทำหน้าที่:
จัดเก็บข้อมูลทั้งหมดในระบบ
ตรวจสอบ ID ซ้ำ
เรียงลำดับการจัดสรร
ตรวจสอบศูนย์เต็ม
บังคับ Business Rules
จัดสรรประชาชนเข้าสู่ศูนย์พักพิง

Enums:
CitizenType
RiskLevel
FilterType
ใช้กำหนดประเภทประชาชน ระดับความเสี่ยง และเงื่อนไขการกรองข้อมูล

Controller
ทำหน้าที่เป็นตัวกลางระหว่าง View และ Model
ไฟล์:
ShelterController.java
รับคำสั่งจาก View แล้วเรียกใช้ ShelterService เช่น:
registerCitizen()
assignAll()
filterCitizens()
getShelters()
getAssignments()
Controller ไม่มี logic ธุรกิจ ทำหน้าที่ส่งต่อคำสั่งเท่านั้น

View
เป็นส่วน UI (Swing GUI) สำหรับผู้ใช้
ไฟล์:
CitizenView.java
หน้าลงทะเบียนประชาชน + แสดงรายชื่อ + filter

ShelterView.java
หน้าจัดสรรที่พัก + แสดงรายละเอียดศูนย์ + ปุ่ม Assign

ReportView.java
หน้ารายงานผล แสดงผู้ที่ได้พัก / ตกค้าง พร้อม filter เด็กและผู้สูงอายุ

Routes / Actions หลัก และ View สำคัญ
Citizen Registration View (CitizenView)
Actions:
Register Citizen
เพิ่มประชาชนใหม่ พร้อมตรวจ ID ซ้ำ

Refresh / Filter
แสดงประชาชนทั้งหมด / แยกตามประเภท / เด็ก / ผู้สูงอายุ

หน้าที่:
ลงทะเบียนประชาชน
ดูรายชื่อทั้งหมด
กรองข้อมูล

Shelter Assignment View (ShelterView)
Actions:
Assign All
เรียก assignAll() เพื่อจัดสรรประชาชนเข้าสู่ศูนย์
แสดง:
รายละเอียดศูนย์พักพิง
ความจุ
จำนวนผู้พักปัจจุบัน

Report View (ReportView)
Actions:
Refresh
Filter (ALL / ASSIGNED / UNASSIGNED / CHILD / ELDERLY)
แสดง:
รายชื่อผู้ที่ได้พัก
รายชื่อผู้ตกค้าง
สถานะของแต่ละคน
