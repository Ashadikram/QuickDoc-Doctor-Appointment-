# 🚑 QuickDoc — Doctor Appointment & Medicine Delivery App

QuickDoc is a healthcare mobile application that enables users to **book doctor appointments**, **schedule online consultations**, and **order medicines with home delivery**.  
This project aims to simplify healthcare access by connecting patients, doctors, and pharmacies on one platform.

---

## 🌟 Features

### 👤 Patient Features
- Register/Login with phone or email
- Search doctors by specialization, fees, rating, and location
- Book in-clinic or online video consultation
- Upload prescriptions & share medical reports
- Order medicines with home delivery
- Real-time order tracking & appointment reminders
- Online payments (UPI/Card) + Cash on Delivery

### 🩺 Doctor Features
- Doctor profile registration with verification
- Manage availability & clinic timings
- Accept/Reject appointments
- Conduct online consultations (chat/video)
- Upload digital prescriptions for patients

### 🔧 Admin Panel (Optional)
- Manage users & doctors
- Verify doctor credentials
- Medicine inventory management
- Track orders & transactions

---

## 🛠 Tech Stack

| Component | Technology |
|----------|------------|
| **Frontend** | Flutter / React Native / Android (Kotlin/Java) |
| **Backend** | Node.js (Express) / Django / Spring Boot |
| **Database** | MySQL / PostgreSQL / MongoDB |
| **Auth & Storage** | Firebase / JWT Auth |
| **Payments** | Razorpay / Stripe |
| **Notifications** | Firebase Cloud Messaging |

---

## 🗃 Database Schema (Basic)

| Table | Description |
|-------|------------|
| `users` | Stores patient info |
| `doctors` | Doctor details & specialization |
| `appointments` | Booked appointments |
| `medicines` | Medicines list & stock info |
| `orders` | Medicine orders |
| `order_items` | Items inside each order |
| `prescriptions` | Uploaded or generated prescriptions |

---

## 📲 Screens (Planned UI)

- Login / Signup
- Doctor List & Filters
- Doctor Profile
- Appointment Booking
- Video Consultation
- Medicine Store
- Order Tracking

(Will update screenshots once UI is completed.)

---

## 🚀 Setup & Installation

```bash
git clone https://github.com/Ashadikram/QuickDoc-Doctor-Appointment
cd quickdoc

npm install
npm start

## ⭐ Support the Project

If you found this project useful, consider giving it a **star ⭐** on GitHub — it really helps!

[⭐ Click here to Star the Repo](#)
